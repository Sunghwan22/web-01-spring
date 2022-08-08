package com.makao.bank.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TransferControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void transferPage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/transfer"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("받는 사람 계좌: ")
        ));
  }

  @Test
  void transfer() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));
  }
}
