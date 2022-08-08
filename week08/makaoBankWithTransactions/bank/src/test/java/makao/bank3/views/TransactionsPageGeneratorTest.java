package makao.bank3.views;

import makao.bank3.models.Account;
import makao.bank3.repositories.AccountRepository;
import makao.bank3.services.AccountService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionsPageGeneratorTest {
  @Test
  void content() {
    AccountRepository accountRepository = new AccountRepository();

    AccountService accountService = new AccountService(accountRepository);

    Account sender = accountService.myAccount();
    Account receiver = accountRepository.find("2345");

    sender.transfer(receiver, 1000);
    receiver.transfer(sender, 500);

    PageGenerator pageGenerator = new TransactionsPageGenerator(sender);

    String html = pageGenerator.content();

    assertThat(html).contains("거래 내역");
    assertThat(html).contains("송금: JOKER 1000원");
    assertThat(html).contains("입금: JOKER 500원");
  }
}
