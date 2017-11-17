package com.homebudget.service;

import com.homebudget.model.MoneyTransaction;

import java.util.List;

public interface MoneyTransactionService {
    public MoneyTransaction findMoneyTransactionByName(String transactionName);
    public void saveMoneyTransaction(MoneyTransaction transaction);
    public List<MoneyTransaction> findAllTransactions();
}
