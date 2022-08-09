package com.makao.letter.contollers;

import com.makao.letter.views.PageGenerator;
import com.makao.letter.views.PostsPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostsController {
  @GetMapping("/posts")
  public String postsPage() {
    PageGenerator pageGenerator = new PostsPageGenerator();
    return pageGenerator.html();
  }
}
