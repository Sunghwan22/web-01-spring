package com.makao.bank.controllers;

import com.makao.bank.models.*;
import com.makao.bank.services.*;
import com.makao.bank.views.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

  private AccountService accountService;

  public AccountController(AccountService accountService) {

    this.accountService = accountService;
  }

  @GetMapping("/account")
  public String account() {
    Account account = accountService.myAccount();

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    return pageGenerator.html();
  }
}
