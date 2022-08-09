package com.makao.letter.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE HTML>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>MakaoBank</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<h1>Makao Letter</h1>" +
        "<nav>\n" +
        "<a href=\"/posts\">글 목록보기</a>  " +
        "<a href=\"/post\">새 글 등록하기</a>" +
        "</nav>" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public abstract String content();
}
