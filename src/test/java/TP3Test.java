import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TP3Test {

  @Test
  public void testSimple() {
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    driver.quit();
  }
}
