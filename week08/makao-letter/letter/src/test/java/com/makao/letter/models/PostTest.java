package com.makao.letter.models;

import com.makao.letter.repositories.PostRepository;
import org.junit.jupiter.api.BeforeEach;
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
    assertThat(1).isEqualTo(post.registrationNumber());
  }

  @Test
  void registrationNumber() {
    Post post1 = new Post("인텔맥은 쓰레기다","M1갖고싶은사람","싸커킥마렵네");
    Post post2 = new Post("제목","저자","내용");
    Post post3 = new Post("제목","저자","내용");

    assertThat(1).isEqualTo(post1.registrationNumber());
    assertThat(2).isEqualTo(post2.registrationNumber());
    assertThat(3).isEqualTo(post3.registrationNumber());
  }
}
