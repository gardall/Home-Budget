package com.lechowiczfamily.homebudget.service;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import com.lechowiczfamily.homebudget.repository.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("moneyTransactionService")
public class MoneyTransactionServiceImpl implements MoneyTransactionService {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    @Override
    public MoneyTransaction findMoneyTransactionByName(String transactionName) {
        return moneyTransactionRepository.findMoneyTransactionByName(transactionName);
    }

    @Override
    public void saveMoneyTransaction(MoneyTransaction transaction) {
        transaction.setAmount(100);
        transaction.setName("Whatever");
        moneyTransactionRepository.save(transaction);
    }
}
