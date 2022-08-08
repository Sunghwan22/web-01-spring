package makao.bank3.views;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HomePageGeneratorTest {
  @Test
  void html() {
    PageGenerator pageGenerator = new HomePageGenerator();

    String html = pageGenerator.html();

    assertThat(html).contains("Hello, world!");
  }
}
