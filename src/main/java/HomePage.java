import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

  private WebDriver driver;
  private By acceptCookieSelector = By.cssSelector("[data-cel-widget=sp-cc-accept]");
  private By searchBarSelector = By.cssSelector("[aria-label=Rechercher]");
  private By searchButtonSelector = By.cssSelector("[type=submit]");

  private final int TIMEOUT_COOKIE = 6;

  public HomePage(WebDriver driver) {
    this.driver = driver;
  }

  public HomePage acceptCookie() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
    WebElement buttonCookie = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookieSelector));
    buttonCookie.click();
    return this;
  }

  public SearchResultPage searchWithButton(String keyword) {
    WebElement searchBar = driver.findElement(searchBarSelector);
    searchBar.sendKeys(keyword);

    WebElement loupeButton = driver.findElement(searchButtonSelector);
    loupeButton.click();

    return new SearchResultPage(driver);
  }
}
