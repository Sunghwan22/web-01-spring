package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();
    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234", "2345", 300);

    assertThat(receiver.amount()).isEqualTo(1300);
  }

  @Test
  void transferNotExistedReceiver() {
    AccountRepository accountRepository = new AccountRepository();
    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234", "-1", 300);

    assertThat(receiver).isNull();
  }
}
