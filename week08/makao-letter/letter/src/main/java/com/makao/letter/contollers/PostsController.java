package com.makao.letter.contollers;

import com.makao.letter.repositories.PostRepository;
import com.makao.letter.views.PageGenerator;
import com.makao.letter.views.PostsPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {
  private PostRepository postRepository;

  public PostsController(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @GetMapping("/posts")
  public String postsPage() {
    PageGenerator pageGenerator = new PostsPageGenerator(postRepository);
    return pageGenerator.html();
  }
}
