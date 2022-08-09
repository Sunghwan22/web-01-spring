package com.makao.bank.controllers;

import com.makao.bank.repositories.AccountRepository;
import com.makao.bank.services.AccountService;
import com.makao.bank.services.TransferService;
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
class TransactionControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private AccountService accountService;

  @SpyBean
  private AccountRepository accountRepository;

  @SpyBean
  private TransferService transferService;

  @Test
  void transactionPage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/transactions"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("거래 내역")
        ));
  }

  @Test
  void transaction() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
            .param("to", "2345")
            .param("amount", "500"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/transactions"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("송금: JOKER 500원")
        ));
  }
}
