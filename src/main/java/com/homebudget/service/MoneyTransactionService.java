package com.homebudget.service;

import com.homebudget.model.MoneyTransaction;
import com.homebudget.model.User;

import java.util.List;

public interface MoneyTransactionService {
    void saveMoneyTransaction(MoneyTransaction transaction);
    List<MoneyTransaction> findAllTransactions();
    List<MoneyTransaction> findCurrentUserTransactions();
}
