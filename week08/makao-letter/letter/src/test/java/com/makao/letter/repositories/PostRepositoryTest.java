package com.makao.letter.repositories;

import com.makao.letter.models.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PostRepositoryTest {
  @Test
  void find() {
    PostRepository postRepository = new PostRepository();

    Post post = new Post("제목", "글쓴이", "내용");

    postRepository.posts().put(999, post);

    Post findPost = postRepository.find(999);

    assertThat("제목").isEqualTo(findPost.title());
    assertThat("글쓴이").isEqualTo(findPost.author());
    assertThat("내용").isEqualTo(findPost.content());
  }
}
