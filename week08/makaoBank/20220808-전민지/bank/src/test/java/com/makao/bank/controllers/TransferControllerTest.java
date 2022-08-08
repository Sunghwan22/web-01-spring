package com.makao.bank.controllers;

import com.makao.bank.repositories.AccountRepository;
import com.makao.bank.services.AccountService;
import com.makao.bank.services.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class TransferControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private TransferService transferService;

  @SpyBean
  private AccountService accountService;

  @SpyBean
  private AccountRepository accountRepository;

  @BeforeEach
  void resetAccounts() {
    accountRepository.reset();
  }

  @Test
  void transferPage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/transfer"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("받는 사람 계좌")
        ));
  }

  @Test
  void transfer500() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
            .param("to", "2345")
            .param("amount", "500"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/account"))
        .andExpect(content().string(
            containsString("잔액: 2500원")
        ));
  }

  @Test
  void transfer1000() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
            .param("to", "2345")
            .param("amount", "1000"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/account"))
        .andExpect(content().string(
            containsString("잔액: 2000")
        ));
  }

  @Test
  void transferWithNotExistedIdentifier() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
            .param("to", "3456")
            .param("amount", "1000"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌번호를 확인해 주세요")
        ));
  }
}
