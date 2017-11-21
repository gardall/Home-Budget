package com.homebudget.controller;

import com.homebudget.model.MoneyTransaction;
import com.homebudget.service.MoneyTransactionService;
import com.homebudget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MoneyTransactionController {

    @Autowired
    private MoneyTransactionService moneyTransactionService;

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        MoneyTransaction moneyTransaction = new MoneyTransaction();
        List<String> targetUserNames = new ArrayList<>();
        String buyerName = new String();
        modelAndView.addObject("targetUserNames",targetUserNames);
        modelAndView.addObject("buyerName",buyerName);
        modelAndView.addObject("moneyTransaction", moneyTransaction);
        modelAndView.addObject("transactions",moneyTransactionService.findAllTransactions());
        modelAndView.addObject("userNames",userService.getUserNames());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    public ModelAndView createNewMoneyTransaction(@Valid MoneyTransaction moneyTransaction, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("dashboard");
        } else {
            moneyTransaction.setBuyer(userService.findUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
            moneyTransaction.setTargetUsers(Arrays.asList(userService.findUserByUsername("user1"), userService.findUserByUsername("admin")));
            moneyTransactionService.saveMoneyTransaction(moneyTransaction);

            modelAndView.addObject("moneyTransaction", new MoneyTransaction());
            modelAndView.addObject("transactions",moneyTransactionService.findAllTransactions());
            modelAndView.addObject("userNames",userService.getUserNames());
            modelAndView.setViewName("dashboard");
        }
        return modelAndView;
    }
}
