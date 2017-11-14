package com.lechowiczfamily.homebudget.service;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;

public interface MoneyTransactionService {
    public MoneyTransaction findMoneyTransactionByName(String transactionName);
    public void saveMoneyTransaction(MoneyTransaction transaction);
}
