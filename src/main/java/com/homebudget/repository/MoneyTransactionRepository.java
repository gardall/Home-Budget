package com.homebudget.repository;

import com.homebudget.model.MoneyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoneyTransactionRepository extends JpaRepository<MoneyTransaction, Integer> {
    MoneyTransaction findMoneyTransactionByName(String transactionName);
}

