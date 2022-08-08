package makao.bank3.controllers;

import makao.bank3.repositories.AccountRepository;
import makao.bank3.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private AccountRepository accountRepository;

  @SpyBean
  private AccountService accountService;

  @Test
  void title() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/transactions"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("거래 내역")
        ));
  }
}
