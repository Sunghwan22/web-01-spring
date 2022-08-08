package com.makao.bank.controllers;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class AccountControllerTest {
   @Autowired
   private MockMvc mockMvc;

   @Test
   void account() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.get("/account"))
          .andExpect(status().isOk())
          .andExpect(content().string(
              containsString("잔액: 3000원")
          ));
   }
}
