package com.makao.bank.repository;

import com.makao.bank.models.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryTest {
  @Test
  void find() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("1234");

    assertThat(account.identifier()).isEqualTo("1234");
    assertThat(account.amount()).isEqualTo(3000);
  }
}
