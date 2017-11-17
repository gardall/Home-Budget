package com.homebudget.controller;

import com.homebudget.model.MoneyTransaction;
import com.homebudget.model.User;
import com.homebudget.service.MoneyTransactionService;
import com.homebudget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.String.format;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.joining;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/dashboard")
    @ResponseBody
    public String testMethod() {

        MoneyTransaction trans = new MoneyTransaction();
        trans.setName("T 1");
        trans.setAmount(100);
        SecurityContextHolder.getContext().getAuthentication().getName();
        trans.setBuyer(userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        moneyTransactionService.saveMoneyTransaction(trans);

        return moneyTransactionService.findAllTransactions()
                .stream()
                .map(moneyTransaction -> format("%d | %d | %s",
                        moneyTransaction.getId(),
                        moneyTransaction.getAmount(),
                        moneyTransaction.getBuyer().getUsername()))
                .collect(collectingAndThen(joining("<br>"), response -> response +"<br>"));
    }
}
