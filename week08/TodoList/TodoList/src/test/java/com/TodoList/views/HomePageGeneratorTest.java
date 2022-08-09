package com.TodoList.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class HomePageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new HomePageGenerator();

    String html = pageGenerator.content();

    assertThat(html).contains("Hello, This is Todo List");
  }

}