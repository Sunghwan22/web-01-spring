package com.makao.bank.views;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import com.makao.bank.services.AccountService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TransactionPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    AccountService accountService = new AccountService(accountRepository);

    Account sender = accountService.myAccount();
    Account receiver = accountRepository.find("2345");

    sender.transfer(receiver, 1000);
    receiver.transfer(sender, 500);

    PageGenerator pageGenerator = new TransactionPageGenerator(sender);

    String html = pageGenerator.content();

    assertThat(html).contains("거래 내역");
    assertThat(html).contains("송금: JOKER 1000원");
    assertThat(html).contains("입금: JOKER 500원");
  }
}
