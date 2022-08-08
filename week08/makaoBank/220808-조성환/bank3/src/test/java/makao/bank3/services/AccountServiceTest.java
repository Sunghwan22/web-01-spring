package makao.bank3.services;

import makao.bank3.models.Account;
import makao.bank3.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {
  @Test
  void findMyAccount() {
    AccountRepository accountRepository = new AccountRepository();

    AccountService accountService = new AccountService(accountRepository);

    Account account = accountService.myAccount();

    assertThat(account.identifier()).isEqualTo("1234");
  }
}
