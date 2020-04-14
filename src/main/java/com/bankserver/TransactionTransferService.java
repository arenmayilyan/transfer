package com.bankserver;


import com.model.domain.dto.TransferTransactionResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.security.provider.certpath.OCSPResponse;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;


@Path("/trans")
@Produces(MediaType.APPLICATION_JSON)
@Component
public final class TransactionTransferService {

    @Autowired
    private ITransactionTransferManager transactionTransferManager;

    /**
     * @param userId
     * @param cardOrAccount
     * @param targetNumber
     * @param amount
     * @param description
     * @param nameSurname
     * @param ignoreEquality
     */
    @POST
    @Path("init_transfer")
    public TransferTransactionResponseDto initTransfer(@FormParam("user_id") long userId,
                                                       @FormParam("cardOrAccount") String cardOrAccount,
                                                       @FormParam("targetNumber") String targetNumber,
                                                       @FormParam("amount") BigDecimal amount,
                                                       @FormParam("fee_amount") BigDecimal feeAmount,
                                                       @FormParam("fee_version") String feeVersion,
                                                       @FormParam("description") String description,
                                                       @FormParam("name_surname") String nameSurname,
                                                       @FormParam("rate_id") int rateId,
                                                       @FormParam("is_own_accounts") int isOwnAccounts,
                                                       @FormParam("ignore_equality") boolean ignoreEquality) {

        TransferTransactionResponseDto result;

        try {

            long accountId = Long.parseLong(cardOrAccount);
            result = transactionTransferManager.initTransfer(userId, accountId, targetNumber, amount, feeAmount, feeVersion,
                    description, nameSurname, rateId, isOwnAccounts, ignoreEquality, false);

        } catch (Exception e) {
            result = new TransferTransactionResponseDto();
            result.setMessage("Internal Server error");
            String msg = "Failed to initialize transfer transaction";

        }

        return result;
    }

}
