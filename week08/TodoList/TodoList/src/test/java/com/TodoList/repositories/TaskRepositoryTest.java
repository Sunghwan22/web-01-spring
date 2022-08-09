package com.TodoList.repositories;

import com.TodoList.models.Task;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskRepositoryTest {
  @Test
  void tasks() {
    TaskRepository taskRepository = new TaskRepository();

    Task task = new Task("햄버거 먹고싶다");

    taskRepository.tasks().add(task);

    assertThat(taskRepository.tasksCount()).isEqualTo(1);
  }
}
