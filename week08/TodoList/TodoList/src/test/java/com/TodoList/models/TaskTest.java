package com.TodoList.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
  @Test
  void creation() {
    Task task = new Task("스프링 뿌시기");

    assertThat("스프링 뿌시기").isEqualTo(task.content());
  }

}