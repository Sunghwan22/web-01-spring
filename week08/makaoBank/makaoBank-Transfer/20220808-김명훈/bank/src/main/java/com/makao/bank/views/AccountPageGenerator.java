package com.makao.bank.views;

import com.makao.bank.models.*;

public class AccountPageGenerator extends PageGenerator {
  private Account account;

  public AccountPageGenerator(Account account) {
    super();
    this.account = account;
  }

  @Override
  public String content() {

    return "<p>계좌번호: " + account.identifier() + "</p>" +
        "<p>이름: " + account.name() + "</p>" +
        "<p>잔액: " + account.amount() + "원</p>";

  }
}
