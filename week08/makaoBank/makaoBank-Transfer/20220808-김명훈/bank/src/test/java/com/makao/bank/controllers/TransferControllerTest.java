package com.makao.bank.controllers;

import com.makao.bank.repository.*;
import com.makao.bank.services.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.*;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = {AccountController.class, TransferController.class})
class TransferControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private AccountRepository accountRepository;

  @SpyBean
  private TransferService transferService;

  @SpyBean
  private AccountService accountService;

  @BeforeEach
  void resetAccountRepository() {
    accountRepository.reset();
  }

  @Test
  void transferPage() throws Exception {

    mockMvc.perform(MockMvcRequestBuilders.get("/transfer"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("보낼계좌")
        ));
  }

  @Test
  void transfer() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
            .param("to", "2345")
            .param("amount", "500"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 이체 성공!")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/account"))
        .andExpect(content().string(
            containsString("잔액: 2500")
        ));
  }

  @Test
  void transferWithWrongAccount() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/transfer")
            .param("to", "-1")
            .param("amount", "500"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("계좌 번호를 확인해주세요.")
        ));

    mockMvc.perform(MockMvcRequestBuilders.get("/account"))
        .andExpect(content().string(
            containsString("잔액: 3000")
        ));
  }
}
