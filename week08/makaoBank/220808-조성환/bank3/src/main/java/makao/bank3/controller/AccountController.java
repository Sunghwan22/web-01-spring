package makao.bank3.controller;

import makao.bank3.models.Account;
import makao.bank3.repositories.AccountRepository;
import makao.bank3.views.AccountPageGenerator;
import makao.bank3.views.PageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  @GetMapping("/account")
  public String account() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("1234");

    PageGenerator pageGenerator = new AccountPageGenerator(account);
    return pageGenerator.html();
  }
}
