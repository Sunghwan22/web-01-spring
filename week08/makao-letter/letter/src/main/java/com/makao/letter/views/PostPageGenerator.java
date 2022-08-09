package com.makao.letter.views;

public class PostPageGenerator extends PageGenerator {
  @Override
  public String content() {
    return "<form method = \"POST\">\n" +
        "<p>제목</p>\n" +
        "<input type=\"text\" name=\"title\">\n" +
        "<p>저자</p>\n" +
        "<input type=\"text\" name=\"author\">\n" +
        "<p>내용</p>\n" +
        "<input type=\"text\" name=\"content\" maxlength=\"50\">\n" +
        "<button type=\"submit\">등록하기</button>\n" +
        "</form>";
  }
}
