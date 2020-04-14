package com.controller;


import com.model.domain.dto.TransferTransactionResponseDto;
import com.exception.ServerUnavailableException;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;


@Path("/trans")
@Produces(MediaType.APPLICATION_JSON)
@Component
public final class TransactionTransferService {

    /**
     * Jersey REST client
     */
    private Client client;

    @POST
    @Path("init_transfer")
    public TransferTransactionResponseDto initTransfer(@FormParam("user_id") long userId,
                                                       @FormParam("card_or_account") String cardOrAccount,
                                                       @FormParam("account_id") long accountId,
                                                       @FormParam("target_account") String targetNumber,
                                                       @FormParam("amount") BigDecimal amount,
                                                       @FormParam("fee_amount") BigDecimal feeAmount,
                                                       @FormParam("fee_version") String feeVersion,
                                                       @FormParam("description") String description,
                                                       @FormParam("name_surname") String nameSurname,
                                                       @FormParam("currencyCode") String curCode,
                                                       @FormParam("rate_id") int rateId,
                                                       @FormParam("is_own_accounts") int isOwnAccounts,
                                                       @FormParam("ignore_equality") boolean ignoreEquality,
                                                       @FormParam("stoken") String stoken) {

        TransferTransactionResponseDto result = new TransferTransactionResponseDto();

        try {

            String url = "http://1.1.1.1:8080/bankserver/trans/init_transfer";

            try {
                Form form = new Form();
                form.param("user_id", String.valueOf(userId));
                form.param("targetNumber", targetNumber);
                form.param("cardOrAccount", cardOrAccount);
                form.param("amount", String.valueOf(amount));
                form.param("fee_amount", feeAmount == null ? null : String.valueOf(feeAmount));
                form.param("fee_version", feeVersion);
                form.param("description", description);
                form.param("name_surname", nameSurname);
                form.param("rate_id", String.valueOf(rateId));
                form.param("is_own_accounts", String.valueOf(isOwnAccounts));
                form.param("ignore_equality", String.valueOf(ignoreEquality));

                // gets response object to check its status
                Response response = client.target(url)
                        .request()
                        .accept(MediaType.APPLICATION_JSON)
                        .post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED));

                // checks whether operation succeeded
                if (response.getStatus() != Response.Status.OK.getStatusCode()) {
                    throw new ServerUnavailableException(response.getStatus() + "Failed to init transfer transaction data");
                }

                // retrieves result data
                result = response.readEntity(TransferTransactionResponseDto.class);
            } catch (ProcessingException e) {
                throw new ServerUnavailableException("Could not connect to remote host [url: " + url + "]", e);
            }

        } catch (ServerUnavailableException e) {
            result.addMessage("Service unavailable");
        } catch (Exception e) {
            result.addMessage("internal server error");
        }
        return result;
    }
}
