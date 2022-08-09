package com.makao.letter.views;

import com.makao.letter.models.Post;
import com.makao.letter.repositories.PostRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostsPageGeneratorTest {
  @Test
  void content() {
    PostRepository postRepository = new PostRepository();

    PageGenerator pageGenerator = new PostsPageGenerator(postRepository);

    String html = pageGenerator.content();

    assertThat(html).contains("저자");
    assertThat(html).contains("<input");
    assertThat(html).contains("찾기");
  }

  @Test
  void postList() {
    PostRepository postRepository = new PostRepository();

    PageGenerator pageGenerator = new PostsPageGenerator(postRepository);

    String html = pageGenerator.content();

    Post post = new Post("제목","글쓴이","내용");

    postRepository.posts().put(post.author(), post);

    assertThat(html).contains("글쓴이");
    assertThat(html).contains("제목");
  }
}
