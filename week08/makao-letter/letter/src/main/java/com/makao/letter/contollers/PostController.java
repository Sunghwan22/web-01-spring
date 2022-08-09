package com.makao.letter.contollers;

import com.makao.letter.views.PageGenerator;
import com.makao.letter.views.PostPageGenerator;
import com.makao.letter.views.PostsPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
  @GetMapping("/post")
  public String postPage() {
    PageGenerator pageGenerator = new PostPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/post")
  public String post(
      @RequestParam("title") String title,
      @RequestParam("writer") String writer,
      @RequestParam("content") String content
  ) {
    PageGenerator pageGenerator = new PostPageGenerator();
    return pageGenerator.html();
  }
}
