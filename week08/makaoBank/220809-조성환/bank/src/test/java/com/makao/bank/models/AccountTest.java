package com.makao.bank.models;

import com.makao.bank.repositories.AccountRepository;
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
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");

    sender.transfer(receiver, 1000);

    assertThat(2000).isEqualTo(sender.amount());
    assertThat(2000).isEqualTo(receiver.amount());
  }

  @Test
  void invaildTransfer() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");

    sender.transfer(receiver, -1030);

    assertThat(3000).isEqualTo(sender.amount());
    assertThat(1000).isEqualTo(receiver.amount());
  }
}
