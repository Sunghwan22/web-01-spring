package com.makao.bank.repository;

import com.makao.bank.models.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Repository
public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    reset();
  }

  public Account find(String identifier) {
    if (accounts.get(identifier) == null) {
      return null;
    }
    Account account = accounts.get(identifier);

    return account;
  }

  public void reset() {
    Stream.of(
        new Account("1234", "Ashal", 3000),
        new Account("2345", "JOKER", 1000)
    ).forEach(account -> accounts.put(account.identifier(), account));
  }
}
