package com.makao.letter.views;

import com.makao.letter.models.Post;
import com.makao.letter.repositories.PostRepository;
import com.makao.letter.services.PostService;
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
  void List() {
    PostRepository postRepository = new PostRepository();

    PostService postService = new PostService(postRepository);

    PostsPageGenerator postsPageGenerator = new PostsPageGenerator(postRepository);

    postService.addPost("제목","글쓴이","내용");

    String html = postsPageGenerator.postList(postRepository.posts());

    assertThat(html).contains("제목");
    assertThat(html).contains("글쓴이");
  }
}
