package com.lechowiczfamily.homebudget.repository;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("moneyTransactionRepository")
public interface MoneyTransactionRepository extends JpaRepository<MoneyTransaction, Integer> {
    MoneyTransaction findMoneyTransactionByName(String transactionName);
}

