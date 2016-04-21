import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.*;
import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();


@Test
  public void coinsCounter_returnsNumberOfQuarters_1() {
    assertEquals("Quarters: 1 Dimes: 0 Nickles: 0 Pennies: 0", App.coinsCounter("25"));
  }
@Test
  public void coinsCounter_returnsNumberOfDimes_2() {
    assertEquals("Quarters: 0 Dimes: 2 Nickles: 0 Pennies: 0", App.coinsCounter("20"));
  }
@Test
  public void coinsCounter_returnsNumberOfNickels_1() {
    assertEquals("Quarters: 0 Dimes: 0 Nickles: 1 Pennies: 0", App.coinsCounter("5"));
  }
@Test
  public void coinsCounter_returnsNumberOfPennies_4() {
    assertEquals("Quarters: 0 Dimes: 0 Nickles: 0 Pennies: 4", App.coinsCounter("4"));
  }
  @Test
    public void coinsCounter_returnsChange_44() {
      assertEquals("Quarters: 1 Dimes: 1 Nickles: 1 Pennies: 4", App.coinsCounter("44"));
    }


@Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    fill("#sentence").with("44");
    submit(".btn");
    assertThat(pageSource()).contains("Quarters: 1 Dimes: 1 Nickles: 1 Pennies: 4");
  }

 //  @Test
 //  public void checkWinner_rock_true() {
 //  App testGame = new App();
 //  assertThat(testGame.checkWinner("r"));
	// }
 //  @Test
 //  public void checkWinner_paper_true() {
 //  App testGame = new App();
 //  assertEquals(true, testGame.checkWinner("p"));
	// }
 //  @Test
 //  public void checkWinner_scissors_true() {
 //  App testGame = new App();
 //  assertEquals(true, testGame.checkWinner("s"));
	//
}
