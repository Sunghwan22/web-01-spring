package com.makao.letter.views;

public class PostsPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return  "<form method = \"POST\">" +
            "<label for=\"writer\">저자:</label>" +
            "<input type=\"text\" name=\"writer\">" +
            "<button type=\"submit\">찾기</button>" +
            "</form>";
  }
}
