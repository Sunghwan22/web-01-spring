package com.makao.bank.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234", "ashal", 3000);

    assertThat(account.identifier()).isEqualTo("1234");
    assertThat(account.name()).isEqualTo("ashal");
    assertThat(account.amount()).isEqualTo(3000);
  }

  @Test
  void transfer() {
    Account sender = new Account("1234", "ashal", 3000);
    Account receiver = new Account("2345", "joker", 1000);

    sender.transfer(receiver, 500);

    assertThat(sender.amount()).isEqualTo(2500);
    assertThat(receiver.amount()).isEqualTo(1500);
  }

  @Test
  void invalidTransfer() {

    Account sender = new Account("1234", "ashal", 3000);
    Account receiver = new Account("2345", "joker", 1000);

    sender.transfer(receiver, -500);

    assertThat(sender.amount()).isEqualTo(3000);
    assertThat(receiver.amount()).isEqualTo(1000);
  }
}
