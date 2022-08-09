package com.makao.letter.contollers;

import com.makao.letter.services.PostService;
import com.makao.letter.views.PageGenerator;
import com.makao.letter.views.PostPageGenerator;
import com.makao.letter.views.PostRegistrationSuccessPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  private PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping("/post")
  public String postPage() {
    PageGenerator pageGenerator = new PostPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/post")
  public String post(
      @RequestParam("title") String title,
      @RequestParam("author") String author,
      @RequestParam("content") String content
  ) {
    postService.addPost(title,author,content);

    PageGenerator pageGenerator = new PostRegistrationSuccessPageGenerator();
    return pageGenerator.html();
  }
}
