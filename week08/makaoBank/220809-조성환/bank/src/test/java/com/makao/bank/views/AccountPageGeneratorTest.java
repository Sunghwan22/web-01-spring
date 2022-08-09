package com.makao.bank.views;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    Account account = accountRepository.find("1234");

    PageGenerator pageGenerator = new AccountPageGenerator(account);

    String html = pageGenerator.content();

    assertThat(html).contains("잔액: 3000원");
    assertThat(html).contains("계좌 번호: 1234");
  }
}
