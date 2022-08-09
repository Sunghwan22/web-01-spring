package com.TodoList.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TasksPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new TasksPageGenerator();

    String html = pageGenerator.content();

    assertThat(html).contains("TodoList");
    assertThat(html).contains("form method=\"POST\"");
    assertThat(html).contains("<label");
    assertThat(html).contains("<input");
    assertThat(html).contains("<button");
  }
}
