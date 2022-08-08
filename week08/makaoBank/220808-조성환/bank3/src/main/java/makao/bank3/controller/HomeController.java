package makao.bank3.controller;

import makao.bank3.views.HomePageGenerator;
import makao.bank3.views.PageGenerator;
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
