package com.lechowiczfamily.homebudget.service;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import com.lechowiczfamily.homebudget.repository.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        moneyTransactionRepository.save(transaction);
    }

    @Override
    public List<MoneyTransaction> findAllTransactions() {
        return moneyTransactionRepository.findAll();
    }
}
