package com.makao.letter.contollers;

import com.makao.letter.views.HomePageGenerator;
import com.makao.letter.views.PageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping("/")
  public String home() {
    PageGenerator pageGenerator = new HomePageGenerator();
    return pageGenerator.html();
  }
}
