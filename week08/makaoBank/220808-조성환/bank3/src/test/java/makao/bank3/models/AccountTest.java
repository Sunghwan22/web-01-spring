package makao.bank3.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234","Ashal",3000);

    assertThat(3000).isEqualTo(account.amount());
    assertThat("1234").isEqualTo(account.identifier());
    assertThat("Ashal").isEqualTo(account.name());
  }

}