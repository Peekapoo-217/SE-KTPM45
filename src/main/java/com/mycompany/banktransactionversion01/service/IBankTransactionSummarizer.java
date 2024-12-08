package com.mycompany.banktransactionversion01.service;

import com.mycompany.banktransactionversion01.model.BankTransaction;

public interface IBankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
