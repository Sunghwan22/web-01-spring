package com.makao.letter.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostRegistrationSuccessPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new PostRegistrationSuccessPageGenerator();

    String html = pageGenerator.content();

    assertThat(html).contains("글 등록이 완료 되었습니다");
  }

}