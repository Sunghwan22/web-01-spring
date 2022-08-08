package com.makao.bank.services;

import com.makao.bank.models.*;
import com.makao.bank.repository.*;
import org.springframework.stereotype.*;

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
