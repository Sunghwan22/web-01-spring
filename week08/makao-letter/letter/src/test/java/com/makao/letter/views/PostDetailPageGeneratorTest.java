package com.makao.letter.views;

import com.makao.letter.models.Post;
import com.makao.letter.repositories.PostRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostDetailPageGeneratorTest {
  @Test
  void content() {
    PostRepository postRepository = new PostRepository();

    int id =999;
    Post post = postRepository.find(999);

    PageGenerator pageGenerator = new PostDetailPageGenerator(postRepository,id);

    String html = pageGenerator.content();

    assertThat(html).contains(post.title());
    assertThat(html).contains("저자: " + post.author());
    assertThat(html).contains(post.content());
  }
}
