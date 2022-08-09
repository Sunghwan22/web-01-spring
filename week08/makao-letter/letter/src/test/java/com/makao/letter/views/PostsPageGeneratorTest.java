package com.makao.letter.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostsPageGeneratorTest {
  @Test
  void content() {
    PageGenerator pageGenerator = new PostsPageGenerator();

    String html = pageGenerator.content();

    assertThat(html).contains("저자");
    assertThat(html).contains("<input");
    assertThat(html).contains("찾기");
  }
}
