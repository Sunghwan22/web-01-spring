package com.makao.bank.controllers;

import com.makao.bank.models.Account;
import com.makao.bank.services.AccountService;
import com.makao.bank.views.PageGenerator;
import com.makao.bank.views.TransactionPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
  private AccountService accountService;

  public TransactionController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/transactions")
  public String transactions() {
    Account account =  accountService.myAccount();

    PageGenerator pageGenerator = new TransactionPageGenerator(account);
    return pageGenerator.html();
  }
}
