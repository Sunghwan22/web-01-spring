package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageGeneratorTest {
  @Test
  void navigation() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "Hello, world";
      }
    };

    String html = pageGenerator.html();

    assertThat(html).contains("Hello, world");
    assertThat(html).contains("Home");
    assertThat(html).contains("잔액 조회");
    assertThat(html).contains("계좌 이체");
  }
}
