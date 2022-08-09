package com.makao.bank.services;

import com.makao.bank.models.Account;
import com.makao.bank.repositories.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account myAccount() {

    Account account = accountRepository.find("1234");

    return account;
  }
}
