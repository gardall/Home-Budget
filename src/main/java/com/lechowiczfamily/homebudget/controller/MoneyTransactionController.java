package com.lechowiczfamily.homebudget.controller;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import com.lechowiczfamily.homebudget.service.MoneyTransactionService;
import com.lechowiczfamily.homebudget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        MoneyTransaction trans = new MoneyTransaction();
                trans.setName("T 1");
                trans.setAmount(100);
                trans.setBuyer(userService.findUserByUsername("admin"));
                moneyTransactionService.saveMoneyTransaction(trans);

        for(MoneyTransaction i: moneyTransactionService.findAllTransactions()) {
            response.append(i.getId())
                    .append("|")
                    .append(i.getAmount())
                    .append("|")
                    .append(i.getBuyer().getUsername())
                    .append("<br>");
        }

        return response.toString();
    }
}
