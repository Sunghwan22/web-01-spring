package com.makao.bank.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "Hello, world!";
      }
    };

    String html = pageGenerator.html();

    assertThat(html).contains("Hello, world!");
    assertThat(html).contains("<html");
    assertThat(html).contains("<a href=\"/\">Home</a>");
    assertThat(html).contains("<a href=\"/account\">잔액 조회</a>");
    assertThat(html).contains("<a href=\"/transfer\">계좌 이체</a>");
  }
}
