package com.TodoList.views;

import com.TodoList.models.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TasksPageGenerator extends PageGenerator {
  private List<Task> tasks;

  public TasksPageGenerator(List<Task> tasks) {
    this.tasks = tasks;
  }

  public TasksPageGenerator() {
    tasks = new ArrayList<>();
  }

  @Override
  public String content() {
    return "<h1>TodoList</h1>\n" +
        "<form method=\"POST\">" +
        "<label for=\"content\">할 일:</label>\n" +
        "<input type=\"text\" name=\"content\"/>\n" +
        "<button type=\"submit\">등록</button>\n" +
        "</form>\n" +
        "<ul>" +
        taskList() +
        "</ul>";
  }

  private String taskList() {
    return tasks.stream()
        .map(task -> "<li>" + task.content() + "</li>\n")
        .collect(Collectors.joining());
  }
}
