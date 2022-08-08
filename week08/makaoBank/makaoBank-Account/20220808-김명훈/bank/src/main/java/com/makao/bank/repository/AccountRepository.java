package com.makao.bank.repository;

import com.makao.bank.models.*;

import java.util.*;
import java.util.stream.*;

public class AccountRepository {
  private Map<String, Account> accounts = new HashMap<>();

  public AccountRepository() {
    Stream.of(
        new Account("1234","Ashal",3000),
        new Account("2345","JOKER",2000)
    ).forEach(account -> accounts.put(account.identifier(),account));
  }

  public Account find(String identifier) {

    Account account = accounts.get(identifier);

    if(account==null) {
      return null;
    }
    return account;
  }
}
