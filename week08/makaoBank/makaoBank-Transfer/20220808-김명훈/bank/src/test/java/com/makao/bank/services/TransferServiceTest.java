package com.makao.bank.services;

import com.makao.bank.models.*;
import com.makao.bank.repository.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();
    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234", "2345", 200);
    assertThat(receiver.amount()).isEqualTo(1000 + 200);
  }
}
