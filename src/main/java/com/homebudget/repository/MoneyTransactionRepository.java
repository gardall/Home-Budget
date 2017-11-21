package com.homebudget.repository;

import com.homebudget.model.MoneyTransaction;
import com.homebudget.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Repository
public interface MoneyTransactionRepository extends JpaRepository<MoneyTransaction, Integer> {
    List<MoneyTransaction> findMoneyTransactionByBuyer(User buyer);
}

