package makao.bank3.views;

import makao.bank3.models.Account;

import java.util.stream.Collectors;

public class TransactionsPageGenerator extends PageGenerator {
  private Account account;

  public TransactionsPageGenerator(Account account) {
    this.account = account;
  }

  @Override
  public String content() {
    return "<h1>거래 내역</h1>\n" +
        account.transactions().stream()
            .map(transaction -> "<p>" +
                transaction.command(account) + ": " +
                transaction.other(account).name() + " " +
                transaction.amount() + "원" +
                "</p>\n")
            .collect(Collectors.joining());
  }
}
