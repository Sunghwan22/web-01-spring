package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    Account receiver = new Account("2345", "JOKER", 1000);

    sender.transfer(receiver, 500);

    assertThat(2500).isEqualTo(sender.amount());
    assertThat(1500).isEqualTo(receiver.amount());
  }

  @Test
  void invalidTransfer() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 1000);

    sender.transfer(receiver, -500);

    assertThat(3000).isEqualTo(sender.amount());
    assertThat(1000).isEqualTo(receiver.amount());
  }
}
