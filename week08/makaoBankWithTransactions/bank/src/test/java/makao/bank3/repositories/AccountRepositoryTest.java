
package makao.bank3.repositories;

import makao.bank3.models.Account;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("1234");

    assertThat("1234").isEqualTo(account.identifier());
  }

  @Test
  void NotFound() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("-1");

    assertThat(account).isNull();
  }
}
