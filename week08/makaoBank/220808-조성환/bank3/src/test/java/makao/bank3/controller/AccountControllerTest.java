package makao.bank3.controller;

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


@WebMvcTest(AccountController.class)
class AccountControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @SpyBean
  private AccountRepository accountRepository;

  @SpyBean
  private AccountService accountService;

  @Test
  void account() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/account"))
        .andExpect(status().isOk())
        .andExpect(content().string(
            containsString("잔액: 3000원")
        ));
  }
}
