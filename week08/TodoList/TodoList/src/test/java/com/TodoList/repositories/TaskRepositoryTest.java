package com.TodoList.repositories;

import com.TodoList.models.Task;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskRepositoryTest {
  @Test
  void tasks() {
    TaskRepository taskRepository = new TaskRepository();

    Task task = new Task("햄버거 먹고싶다");

    taskRepository.add(task);

    assertThat(taskRepository.tasksCount()).isEqualTo(1);
  }

  @Test
  void tasksCount() {
    TaskRepository taskRepository = new TaskRepository();

    Task task = new Task("삘레 걷기");

    int oldTaskCount = taskRepository.tasksCount();

    taskRepository.add(task);

    int newTaskCount = taskRepository.tasksCount();

    assertThat(newTaskCount - oldTaskCount).isEqualTo(1);
  }
}
