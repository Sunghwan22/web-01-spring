package com.makao.letter.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new PostPageGenerator();

    String html = pageGenerator.content();

    assertThat(html).contains("제목");
    assertThat(html).contains("저자");
    assertThat(html).contains("내용");
    assertThat(html).contains("<input");
    assertThat(html).contains("<button");
  }
}
