package com.makao.bank.controllers;

import com.makao.bank.views.PageGenerator;
import com.makao.bank.views.TransferPageGenerator;
import com.makao.bank.views.TransferSuccessPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {

  @GetMapping("/transfer")
  public String transferPage() {
    PageGenerator pageGenerator = new TransferPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/transfer")
  public String transfer() {
    PageGenerator pageGenerator = new TransferSuccessPageGenerator();
    return pageGenerator.html();
  }
}
