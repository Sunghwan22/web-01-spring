package com.makao.bank.views;

public class TransferPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method=\"POST\">" +
        "<p>" +
        "받는 사람 계좌: " +
        "<input type=\"text\" name=\"to\">" +
        "</p>\n" +
        "<p>" +
        "보낼 금액: " +
        "<input type=\"number\" name=\"amount\">" +
        "</p>\n" +
        "<button type=\"submit\">확인</button>\n" +
        "</form>";
  }
}
