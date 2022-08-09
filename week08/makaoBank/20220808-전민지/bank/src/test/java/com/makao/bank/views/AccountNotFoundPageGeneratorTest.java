package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountNotFoundPageGeneratorTest {
  @Test
  void content() {
  PageGenerator pageGenerator = new AccountNotFoundPageGenerator();

  String html = pageGenerator.content();

  assertThat(html).contains("계좌번호를 확인해 주세요");
  }
}
