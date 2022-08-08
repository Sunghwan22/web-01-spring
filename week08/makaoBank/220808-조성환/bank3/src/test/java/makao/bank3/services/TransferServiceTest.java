package makao.bank3.services;

import makao.bank3.models.Account;
import makao.bank3.repositories.AccountRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TransferServiceTest {
  @Test
  void transfer() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234","2345",500);

    assertThat(receiver.amount()).isEqualTo(1500);
  }

  @Test
  void transferWithWrongReceiver() {
    AccountRepository accountRepository = new AccountRepository();

    TransferService transferService = new TransferService(accountRepository);

    Account receiver = transferService.transfer("1234","-1",500);

    assertThat(receiver).isNull();
  }
}
