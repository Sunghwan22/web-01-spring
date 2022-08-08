package com.makao.bank.controllers;

import com.makao.bank.models.*;
import com.makao.bank.services.*;
import com.makao.bank.views.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransferController {
  private TransferService transferService;
  private AccountService accountService;

  public TransferController(TransferService transferService, AccountService accountService) {
    this.transferService = transferService;
    this.accountService = accountService;
  }

  @GetMapping("/transfer")
  public String transfer() {
    PageGenerator pageGenerator = new TransferPageGenerator();

    return pageGenerator.html();
  }

  @PostMapping("/transfer")
  public String transferSuccess(
      @RequestParam("to") String to,
      @RequestParam("amount") long amount
  ) {
    Account myAccount = accountService.myAccount();
    Account receiver = transferService.transfer(myAccount.identifier(), to, amount);

    PageGenerator pageGenerator = receiver == null
        ? new AccountNotFoundPageGenerator()
        : new TransferSuccessPageGenerator();

    return pageGenerator.html();
  }
}
