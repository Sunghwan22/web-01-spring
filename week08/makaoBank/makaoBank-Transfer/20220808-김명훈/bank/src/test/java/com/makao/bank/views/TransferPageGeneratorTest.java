package com.makao.bank.views;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransferPageGeneratorTest {
  @Test
  void content() {
    TransferPageGenerator pageGenerator = new TransferPageGenerator();

    String html = pageGenerator.html();

    assertThat(html).contains("보낼계좌:");
    assertThat(html).contains("<input type=\"text\"");
    assertThat(html).contains("보낼금액:");
    assertThat(html).contains("<input type=\"number\"");
  }
}
