package com.makao.bank.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void content1() {
    HomeController homeController = new HomeController();

    String html = homeController.home();

    assertThat(html).contains("Hello, world!");
  }

  @Test
  void mockMvcHome() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("Hello, world!")
        ));
  }
}
