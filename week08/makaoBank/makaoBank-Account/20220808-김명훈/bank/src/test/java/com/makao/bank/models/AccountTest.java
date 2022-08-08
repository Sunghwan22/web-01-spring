package com.makao.bank.models;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
  @Test
  void creation() {
    Account account = new Account("1234","Ashal",3000);

    assertThat("1234").isEqualTo(account.identifier());
    assertThat("Ashal").isEqualTo(account.name());
    assertThat(3000).isEqualTo(account.amount());
  }

}