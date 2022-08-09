package com.makao.letter.views;

import com.makao.letter.models.Post;
import com.makao.letter.repositories.PostRepository;

import java.util.Map;

public class PostsPageGenerator extends PageGenerator {
  private PostRepository postRepository;

  public PostsPageGenerator(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public String content() {
    return  "<form method = \"POST\">" +
            "<label for=\"writer\">저자:</label>" +
            "<input type=\"text\" name=\"writer\">" +
            "<button type=\"submit\">찾기</button>" +
            "</form>" +
            "<ul>" +
            postList(postRepository.posts()) +
            "</ul>";
  }

  private String postList(Map<String, Post> posts) {
    String list = "";
    for(Post post : posts.values()) {
      list += "<li><a href=\"/\">" + post.author() + "by" + post.title() +"</a></li>";
    }
    return list;
  }
}
