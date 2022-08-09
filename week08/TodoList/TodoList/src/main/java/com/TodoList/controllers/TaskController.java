package com.TodoList.controllers;

import com.TodoList.models.Task;
import com.TodoList.services.TaskService;
import com.TodoList.views.PageGenerator;
import com.TodoList.views.TasksPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {
  private TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @GetMapping("/tasks")
  public String tasks() {
    PageGenerator pageGenerator = new TasksPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/tasks")
  public String addTask(
      @RequestParam("content") String content
  ) {
    List<Task> tasks = taskService.addTask(content);

    PageGenerator pageGenerator = new TasksPageGenerator(tasks);
    return pageGenerator.html();
  }
}
