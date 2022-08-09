package com.makao.letter.repositories;

import com.makao.letter.models.Post;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public class PostRepository {
  private Map<Integer, Post> posts = new LinkedHashMap<>();

  public PostRepository() {
    Stream.of(
        new Post("제목","내용","글쓴이")
    ).forEach(post -> posts.put(999, post));

  }

  public Map<Integer,Post> posts() {
    return posts;
  }

  public Post find(int registrationNumber) {
    return posts.get(registrationNumber);
  }
}
