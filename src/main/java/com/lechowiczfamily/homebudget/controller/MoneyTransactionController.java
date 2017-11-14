package com.lechowiczfamily.homebudget.controller;

import com.lechowiczfamily.homebudget.model.MoneyTransaction;
import com.lechowiczfamily.homebudget.repository.MoneyTransactionRepository;
import com.lechowiczfamily.homebudget.service.MoneyTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionRepository moneyTransactionRepository;

    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        MoneyTransaction trans = new MoneyTransaction();
                trans.setName("T 1");
                trans.setAmount(100);
                moneyTransactionRepository.save(trans);

        for(MoneyTransaction i: moneyTransactionRepository.findAll()) {
            response.append(i).append("<br>");
        }

        return response.toString();
    }
}
