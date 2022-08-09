package com.makao.letter.services;

import com.makao.letter.models.Post;
import com.makao.letter.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public void addPost(String title, String author, String content) {
    Post post = new Post(title,author,content);

    postRepository.posts().put(author,post);
  }
}
