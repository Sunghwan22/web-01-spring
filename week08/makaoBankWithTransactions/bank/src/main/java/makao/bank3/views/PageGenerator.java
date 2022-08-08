package makao.bank3.views;

public abstract class PageGenerator {
  public String html() {
    return "<!DOCTYPE HTML>\n" +
        "<html>\n" +
        "<head>\n" +
        "<meta charset=\"UTF-8\">\n" +
        "<title>MakaoBank</title>\n" +
        "</head>\n" +
        "<body>\n" +
        "<nav>\n" +
        navigation() +
        "</nav>" +
        content() +
        "</body>\n" +
        "</html>";
  }

  public String navigation() {
    return   "<a href=\"/\">Home</a> " +
        "<a href=\"/account\">잔액 조회</a> " +
        "<a href=\"/transfer\">계좌 이체</a> " +
        "<a href=\"/transactions\">거래 내역</a>";
  }


  public abstract String content();
}
