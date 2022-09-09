package amazon;

import org.openqa.selenium.WebDriver;

public class CartPage {

  private WebDriver driver;

  public CartPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getSubTotal() {
    return "1000";
  }
}
