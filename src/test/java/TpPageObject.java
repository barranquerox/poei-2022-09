import amazon.CartPage;
import amazon.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {

  WebDriver driver;

  @BeforeMethod
  public void setup() {
    driver = new ChromeDriver();
    driver.get("https://www.amazon.fr/");
    driver.manage().window().maximize();
  }

  @AfterMethod
  public void teardown() {
    driver.quit();

  }

  @Test
  public void testPO() {
    final String keyword = "iPhone 13";

    HomePage homePage = new HomePage(driver);
    CartPage cartPage = homePage.acceptCookie()
        .searchWithButton(keyword)
        .openSearchResult(0)
        .addToCart()
        .refuseAppleCare()
        .openCartPage();

    Assert.assertEquals(cartPage.getSubTotal(), "1000");
  }

  @Test
  public void test2() {
    HomePage homePage = new HomePage(driver);

    WebElement loginButton = driver.findElement(By.cssSelector("#nav-link-accountList"));

    Actions actions = new Actions(driver);
    actions.moveToElement(loginButton);
    actions.perform();  // third test

    try {
      Thread.sleep(4000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

  }
}
