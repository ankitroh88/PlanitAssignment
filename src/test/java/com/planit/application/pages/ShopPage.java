package com.planit.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage extends BasePage {

  private By cartMenu = By.xpath("//a[@href='#/cart']");
  private By cartTotal = By.xpath("//strong[@class='total ng-binding']");

  public ShopPage(WebDriver driver) {
    super(driver);
  }

  public void goToCart() {
    driver.findElement(cartMenu).click();
  }

  public String getCartTotal() {
    return driver.findElement(cartTotal).getText().substring(7);
  }

  private By addItemButton(String itemName) {
    return By.xpath("//h4[(text()='" + itemName + "')]/../p/a");
  }

  private By itemUnitPriceInCart(String itemName) {
    return By.xpath("//h4[(text()='" + itemName + "')]/../p/span");
  }

  private By itemSubTotalInCart(String itemName) {
    return By.xpath("//*[contains(text(),'" + itemName + "')]/../td[4]");
  }

  public ShopPage addItemToCart(String itemName) {
    driver.findElement(addItemButton(itemName)).click();
    return this;
  }

  public String getItemUnitPriceInCart(String itemName) {
    String itemprice = driver
      .findElement(itemUnitPriceInCart(itemName))
      .getText();
    return itemprice.substring(1);
  }

  public String getItemSubtotalInCart(String itemName) {
    String itemsubtotal = driver
      .findElement(itemSubTotalInCart(itemName))
      .getText();
    return itemsubtotal.substring(1);
  }

  public String getExpectedSubtotal(String itemName, int quantity)
    throws Exception {
    String itemprice = "";

    switch (itemName) {
      case "Stuffed Frog":
        itemprice = "10.99";
        break;
      case "Fluffy Bunny":
        itemprice = "9.99";
        break;
      case "Valentine Bear":
        itemprice = "14.99";
        break;
      default:
        throw new Exception("Unsupported item: " + itemName);
    }
    return Double.toString(Double.parseDouble(itemprice) * (quantity));
  }
}
