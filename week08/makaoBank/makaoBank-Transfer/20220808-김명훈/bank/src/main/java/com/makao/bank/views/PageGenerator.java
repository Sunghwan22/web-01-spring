package com.makao.bank.views;

public abstract class PageGenerator {

  public String html() {
    return "<!DOCTYPE html>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>makaoBank</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<nav>" +
        "<a href=\"/\">Home</a> \n" +
        "<a href=\"/account\">잔액확인</a> \n" +
        "<a href=\"/transfer\">송금</a>\n" +
        content() +
        "</body>\n";
  }

  public abstract String content();
}
