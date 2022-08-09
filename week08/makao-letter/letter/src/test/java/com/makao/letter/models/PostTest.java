package com.makao.letter.models;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostTest {
  @Test
  void creation() {
    Post post = new Post("인텔맥은 쓰레기다","M1갖고싶은사람","싸커킥마렵네");

    assertThat("인텔맥은 쓰레기다").isEqualTo(post.title());
    assertThat("M1갖고싶은사람").isEqualTo(post.author());
    assertThat("싸커킥마렵네").isEqualTo(post.content());
  }

}