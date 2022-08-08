package com.makao.bank.controllers;

import com.makao.bank.views.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

  @GetMapping("/")
  public String home() {
    PageGenerator pageGenerator = new HomePageGenerator();

    return pageGenerator.html();
  }
}
