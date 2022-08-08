package makao.bank3.controllers;

import makao.bank3.models.Account;
import makao.bank3.services.AccountService;
import makao.bank3.views.PageGenerator;
import makao.bank3.views.TransactionsPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
  private AccountService accountService;

  public TransactionController(AccountService accountService) {
    this.accountService = accountService;
  }

  @GetMapping("/transactions")
  public String transaction() {
    Account account = accountService.myAccount();

    PageGenerator pageGenerator = new TransactionsPageGenerator(account);
    return pageGenerator.html();
  }
}
