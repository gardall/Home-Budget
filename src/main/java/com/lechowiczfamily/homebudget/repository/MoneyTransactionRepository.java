package com.lechowiczfamily.homebudget.repository;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MoneyTransactionRepository {

    @Repository("moneyTransactionRepository")
    interface RoleRepository extends JpaRepository<MoneyTransaction, Integer> {
        List<MoneyTransaction> findAll();
        List<MoneyTransaction> findLatest5();
        MoneyTransaction findById(Long id);
        MoneyTransaction create(MoneyTransaction transaction);
        MoneyTransaction edit(MoneyTransaction transaction);
        void deleteById(Long id);
    }
}
