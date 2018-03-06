package foo

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;

@RunWith(JUnit4.class)
public class WebTestTest {

  @Test
  public void newWebDriverSession() {
    WebDriver driver = new WebTest().newWebDriverSession();
    driver.quit();
  }
}
