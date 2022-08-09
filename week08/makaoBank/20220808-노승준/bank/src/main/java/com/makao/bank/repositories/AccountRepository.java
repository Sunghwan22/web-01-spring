package com.makao.bank.repositories;

import com.makao.bank.models.Account;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class AccountRepository {
  Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    reset();
  }

  public Account find(String identifier) {
    if(!accounts.containsKey(identifier)) {
      return null;
    }

    Account account = accounts.get(identifier);

    return account;
  }

  public void reset() {
    Stream.of(
        new Account("1234", "ashal", 3000),
        new Account("2345", "joker", 1000)
    ).forEach(account -> accounts.put(account.identifier(), account));
  }
}
