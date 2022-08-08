package com.makao.bank.repository;

import com.makao.bank.models.*;
import com.makao.bank.services.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class AccountServiceTest {
  @Test
  void findByIdentity() {
    AccountRepository accountRepository = new AccountRepository();
    AccountService accountService = new AccountService(accountRepository);

    Account account = accountService.myAccount();

    assertThat(account.identifier()).isEqualTo("1234");
  }
}
