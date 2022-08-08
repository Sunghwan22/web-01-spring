package makao.bank3.controller;

import makao.bank3.models.Account;
import makao.bank3.services.AccountService;
import makao.bank3.views.AccountPageGenerator;
import makao.bank3.views.PageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
