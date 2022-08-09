package com.makao.letter.services;

import com.makao.letter.repositories.PostRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PostServiceTest {
  @Test
  void register() {
    PostRepository postRepository = new PostRepository();

    PostService postService = new PostService(postRepository);

    postService.addPost("페페란","페페","바로나다");

    assertThat(postRepository.posts().size()).isEqualTo(1);
  }
}
