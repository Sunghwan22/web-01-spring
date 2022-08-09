package com.makao.bank.repositories;

import com.makao.bank.models.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("1234", "Ashal", 3000)

    ).forEach(account -> accounts.put(account.identifier(), account));
  }

  public Account find(String identifier) {
    if (!accounts.containsKey(identifier)) {
      return null;
    }

    return accounts.get(identifier);
  }
}
