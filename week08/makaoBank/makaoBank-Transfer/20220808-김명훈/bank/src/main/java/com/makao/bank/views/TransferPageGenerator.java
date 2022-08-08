package com.makao.bank.views;

import com.makao.bank.views.*;

public class TransferPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method=\"POST\">\n" +
        "<p>\n" +
        "보낼계좌:" +
        "<input type=\"text\" name=\"to\">\n" +
        "</p>\n" +
        "<p>\n" +
        "보낼금액:" +
        "<input type=\"number\" name=\"amount\">\n" +
        "</p>\n" +
        "<button type=\"submit\">확인</button>" +
        "</form>";
  }
}
