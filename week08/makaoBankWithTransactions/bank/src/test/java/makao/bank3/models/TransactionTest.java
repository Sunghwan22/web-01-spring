package makao.bank3.models;

import makao.bank3.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransactionTest {
  @Test
  void creation() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");
    long amount = 800;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertThat(sender).isEqualTo(transaction.sender());
    assertThat(receiver).isEqualTo(transaction.receiver());
    assertThat(800).isEqualTo(transaction.amount());
  }

  @Test
  void command() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");
    long amount = 800;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertThat("송금").isEqualTo(transaction.command(sender));
    assertThat("입금").isEqualTo(transaction.command(receiver));
  }

  @Test
  void other() {
    AccountRepository accountRepository = new AccountRepository();

    Account sender = accountRepository.find("1234");
    Account receiver = accountRepository.find("2345");
    long amount = 800;

    Transaction transaction = new Transaction(sender, receiver, amount);

    assertThat(receiver).isEqualTo(transaction.other(sender));
    assertThat(sender).isEqualTo(transaction.other(receiver));
  }
}
