package makao.bank3.services;

import makao.bank3.models.Account;
import makao.bank3.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account myAccount() {
    return accountRepository.find("1234");
  }
}
