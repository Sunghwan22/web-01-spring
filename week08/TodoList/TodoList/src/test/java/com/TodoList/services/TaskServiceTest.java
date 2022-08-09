package com.TodoList.services;

import com.TodoList.models.Task;
import com.TodoList.repositories.TaskRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TaskServiceTest {
  @Test
  void addTask() {
    TaskRepository taskRepository = new TaskRepository();

    TaskService taskService = new TaskService(taskRepository);

    taskService.addTask("저녁 먹기");

    assertThat(taskRepository.tasksCount()).isEqualTo(1);
  }
}
