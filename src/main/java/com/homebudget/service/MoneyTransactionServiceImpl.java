package com.homebudget.service;

import com.homebudget.model.MoneyTransaction;
import com.homebudget.model.User;
import com.homebudget.repository.MoneyTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("moneyTransactionService")
public class MoneyTransactionServiceImpl implements MoneyTransactionService {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    @Autowired
    private UserService userService;

    @Override
    public void saveMoneyTransaction(MoneyTransaction transaction) {
        moneyTransactionRepository.save(transaction);
    }

    @Override
    public List<MoneyTransaction> findAllTransactions() {
        return moneyTransactionRepository.findAll();
    }

    @Override
    public List<MoneyTransaction> findCurrentUserTransactions() {
        return moneyTransactionRepository.findMoneyTransactionByBuyer(userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
        );
    }
}
