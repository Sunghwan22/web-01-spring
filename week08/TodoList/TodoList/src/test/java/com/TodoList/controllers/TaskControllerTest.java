package com.TodoList.controllers;

import com.TodoList.repositories.TaskRepository;
import com.TodoList.services.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
class TaskControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private TaskService taskService;

  @SpyBean
  private TaskRepository taskRepository;

  @Test
  void taskPage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("TodoList")
        ));
  }

  @Test
  void tasks() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/tasks")
            .param("content", "스프링 공부하기"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("스프링 공부하기")
        ));
  }
}
