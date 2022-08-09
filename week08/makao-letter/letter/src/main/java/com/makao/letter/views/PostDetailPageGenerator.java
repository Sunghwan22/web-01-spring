package com.makao.letter.views;

import com.makao.letter.models.Post;
import com.makao.letter.repositories.PostRepository;

public class PostDetailPageGenerator extends PageGenerator {
  private PostRepository postRepository;
  private int id;

  public PostDetailPageGenerator(PostRepository postRepository, int id) {
    this.postRepository = postRepository;
    this.id = id;
  }

  @Override
  public String content() {
    return "<h2>" + post().title() + "</h2>" +
        "<p>저자: " + post().author() + "</p>" +
        "<p>" + post().content() + "</p>";
  }

  public Post post() {
    return postRepository.find(id);
  }
}
