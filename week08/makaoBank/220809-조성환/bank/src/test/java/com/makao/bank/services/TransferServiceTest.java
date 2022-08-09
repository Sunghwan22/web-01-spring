package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
  @Test
  void transfer() {
    long amount = 500;

    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234","2345",500);

    assertThat(1500).isEqualTo(receiver.amount());
  }

  @Test
  void transferWithWrongReceiver() {
    long amount = 500;

    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234","-123873",500);

    assertThat(receiver).isNull();
  }
}
