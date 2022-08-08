package com.makao.bank.views;

import com.makao.bank.models.*;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AccountPageGeneratorTest {
  @Test
  void content() {
    Account account = new Account("1234","Ashal",3000);
    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.html();

    assertThat(html).contains("계좌번호: 1234");
    assertThat(html).contains("이름: Ashal");
    assertThat(html).contains("잔액: 3000원");

  }
}