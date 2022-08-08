package com.makao.bank.views;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HomePageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new HomePageGenerator();

    String html = pageGenerator.html();

    assertThat(html).contains("Hello, world!");
  }

}