package com.bankserver;

import com.model.domain.dto.TransferTransactionResponseDto;

import java.math.BigDecimal;


public interface ITransactionTransferManager {
    TransferTransactionResponseDto initTransfer(long userID,
                                                long accountID,
                                                String targetAccount,
                                                BigDecimal amount,
                                                BigDecimal feeAmount,
                                                String feeVersion,
                                                String description,
                                                String nameSurname,
                                                int rateId,
                                                int isOwnAccounts,
                                                boolean ignoreEquality,
                                                boolean isRecurring) throws Exception;


}
