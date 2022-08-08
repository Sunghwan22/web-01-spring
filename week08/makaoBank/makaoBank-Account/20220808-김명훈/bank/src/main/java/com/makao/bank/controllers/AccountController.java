package com.makao.bank.controllers;

import com.makao.bank.models.*;
import com.makao.bank.repository.*;
import com.makao.bank.views.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

  private AccountRepository accountRepository;

  public AccountController() {
    accountRepository = new AccountRepository();
  }

  @GetMapping("/account")
  public String account() {
    Account account = accountRepository.find("1234");

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    return pageGenerator.html();
  }
}
