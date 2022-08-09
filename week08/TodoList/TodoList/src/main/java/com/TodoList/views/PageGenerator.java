package com.TodoList.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE HTML>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>TodoList</title>\n" +
        "</head>\n" +
        "<body>\n" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public abstract String content();
}
