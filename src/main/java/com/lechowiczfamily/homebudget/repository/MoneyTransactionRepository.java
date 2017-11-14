package com.lechowiczfamily.homebudget.repository;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface MoneyTransactionRepository {

    @Repository("moneyTransactionRepository")
    interface RoleRepository extends JpaRepository<MoneyTransaction, Integer> {
    }
}
