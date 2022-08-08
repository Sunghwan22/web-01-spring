package makao.bank3.services;

import makao.bank3.models.Account;
import makao.bank3.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferService {
  private AccountRepository accountRepository;

  public TransferService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account transfer(String from, String to, long amount) {
    Account receiver = accountRepository.find(to);
    if(receiver == null) {
      return null;
    }

    Account sender = accountRepository.find(from);
    sender.transfer(receiver, amount);

    return receiver;
  }
}
