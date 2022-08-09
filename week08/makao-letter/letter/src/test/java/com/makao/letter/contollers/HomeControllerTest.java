package com.makao.letter.contollers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class HomeControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void Home() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/"))
          .andExpect(status().isOk())
          .andExpect(content().string(
              containsString("Hello, world")
          ));
  }
}