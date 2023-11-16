package com.planit.application.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

  private By contactButton = By.xpath("//a[normalize-space()='Contact']");
  private By shopButton = By.xpath("//a[normalize-space()='Shop']");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  public ContactPage clickContactMenu() {
    driver.findElement(contactButton).click();
    return new ContactPage(driver);
  }

  public ShopPage clickShopMenu() {
    driver.findElement(shopButton).click();
    return new ShopPage(driver);
  }
}
