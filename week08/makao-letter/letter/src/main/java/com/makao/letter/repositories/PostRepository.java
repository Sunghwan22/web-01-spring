package com.makao.letter.repositories;

import com.makao.letter.models.Post;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {
  private Map<String, Post> posts = new HashMap<>();

  public Map<String,Post> posts() {
    return posts;
  }
// todo find기능 구현해야함
//  public Post find() {
//    return
//  }
}
