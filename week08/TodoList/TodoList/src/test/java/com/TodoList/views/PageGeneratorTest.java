package com.TodoList.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new PageGenerator() {
      @Override
      public String content() {
        return "Hello";
      }
    };

    String html = pageGenerator.html();

    assertThat(html).contains("<html");
    assertThat(html).contains("Hello");
  }
}
