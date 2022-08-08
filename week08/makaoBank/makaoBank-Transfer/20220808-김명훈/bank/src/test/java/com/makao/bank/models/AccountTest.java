package com.makao.bank.models;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "Ashal", 3000);

    assertThat("1234").isEqualTo(account.identifier());
    assertThat("Ashal").isEqualTo(account.name());
    assertThat(3000).isEqualTo(account.amount());
  }

  @Test
  void transfer() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 3000);

    sender.transfer(receiver, 1000);

    assertThat(sender.amount()).isEqualTo(2000);
    assertThat(receiver.amount()).isEqualTo(4000);
  }

  @Test
  void invalidTransfer() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 3000);

    sender.transfer(receiver, -500);

    assertThat(sender.amount()).isEqualTo(3000);
    assertThat(receiver.amount()).isEqualTo(3000);
  }
}
