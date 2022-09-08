import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
    homePage.acceptCookie();
    homePage.searchWithButton(keyword);
    SearchResultPage searchResultPage = new SearchResultPage(driver);
    searchResultPage.openSearchResult(0);
    ProductPage productPage = new ProductPage(driver);
    productPage.addToCart();
    productPage.refuseAppleCare();
    productPage.openCartPage();
  }
}
