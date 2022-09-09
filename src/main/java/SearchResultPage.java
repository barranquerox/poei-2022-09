import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

  private WebDriver driver;
  private By productImageSelector = By.cssSelector("img.s-image");

  public SearchResultPage(WebDriver driver) {
    this.driver = driver;
  }

  public ProductPage openSearchResult(int index) {
    List<WebElement> resultatList = driver.findElements(productImageSelector);
    resultatList.get(index).click();
    return new ProductPage(driver);
  }
}
