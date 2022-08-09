package com.makao.bank.models;

import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

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

  @Test
  void transactionCount() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 1000);

    int oldSenderTransactionCount = sender.transactionsCount();
    int oldReceiverTransactionCount = sender.transactionsCount();

    sender.transfer(receiver, 500);

    int newSenderTransactionCount = sender.transactionsCount();
    int newReceiverTransactionCount = sender.transactionsCount();

    assertThat(1).isEqualTo(newSenderTransactionCount - oldSenderTransactionCount);
    assertThat(1).isEqualTo(newReceiverTransactionCount - oldReceiverTransactionCount);
  }

  @Test
  void transactions() {
    Account sender = new Account("1234", "Ashal", 3000);
    Account receiver = new Account("2345", "JOKER", 1000);

    sender.transfer(receiver, 500);

    assertThat(1).isEqualTo(sender.transactions().size());
    assertThat(1).isEqualTo(receiver.transactions().size());
  }

  @Test
  void equals() {
    Account account1 = new Account("1234", "Ashal", 3000);
    Account account2 = new Account("2345", "JOKER", 1000);

    assertThat(account1).isEqualTo(account1);
    assertFalse(account1.equals(account2));
  }
}

