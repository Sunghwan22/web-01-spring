package makao.bank3.repositories;

import makao.bank3.models.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("1234","Ashal",3000)
    ).forEach(account -> accounts.put(account.identifier(), account));
  }

  public Account find(String identifier) {
    return accounts.get(identifier);
  }
}
