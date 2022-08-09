package com.TodoList.services;

import com.TodoList.models.Task;
import com.TodoList.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
  private TaskRepository taskRepository;

  public TaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> addTask(String content) {
    Task task = new Task(content);

    taskRepository.add(task);
    return taskRepository.tasks();
  }
}
