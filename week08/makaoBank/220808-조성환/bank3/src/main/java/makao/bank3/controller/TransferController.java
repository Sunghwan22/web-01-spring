package makao.bank3.controller;


import makao.bank3.models.Account;
import makao.bank3.services.TransferService;
import makao.bank3.views.AccountNotFoundPageGenerator;
import makao.bank3.views.PageGenerator;
import makao.bank3.views.TransferPageGenerator;
import makao.bank3.views.TransferSuccessPageGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferController {
  private TransferService transferService;

  public TransferController(TransferService transferService) {
    this.transferService = transferService;
  }

  @GetMapping("/transfer")
  public String transferPage() {
    PageGenerator pageGenerator = new TransferPageGenerator();
    return pageGenerator.html();
  }

  @PostMapping("/transfer")
  public String transfer(
      @RequestParam("to") String to,
      @RequestParam("amount") long amount
  ) {

    Account receiver = transferService.transfer("1234",to,amount);

    PageGenerator pageGenerator = receiver == null
        ? new AccountNotFoundPageGenerator()
        : new TransferSuccessPageGenerator();

    return pageGenerator.html();
  }
}
