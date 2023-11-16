package com.planit.application.pages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage {

  private By submitButton = By.className("btn-contact");
  private By forenameErrorText = By.id("forename-err");
  private By emailErrorText = By.id("email-err");
  private By messageErrorText = By.id("message-err");
  private By forenameTextfield = By.id("forename");
  private By surnameTextfield = By.id("surname");
  private By emailTextfield = By.id("email");
  private By telephoneTextfield = By.id("telephone");
  private By messageTextfield = By.id("message");
  private By successMessage = By.className("alert-success");

  public ContactPage(WebDriver driver) {
    super(driver);
  }

  public ContactPage clickSubmitButton() {
    driver.findElement(submitButton).click();
    return this;
  }

  public String getForenameError() {
    return getErrorText(forenameErrorText);
  }

  public String getEmailError() {
    return getErrorText(emailErrorText);
  }

  public String getMessageError() {
    return getErrorText(messageErrorText);
  }

  private String getErrorText(By locator) {
    List<WebElement> errorMsg = driver.findElements(locator);
    if (errorMsg.isEmpty()) {
      return "";
    }
    return errorMsg.get(0).getText();
  }

  public ContactPage setForename(String forename) {
    driver.findElement(forenameTextfield).sendKeys(forename);
    return this;
  }

  public ContactPage setSurname(String surname) {
    driver.findElement(surnameTextfield).sendKeys(surname);
    return this;
  }

  public ContactPage setEmail(String email) {
    driver.findElement(emailTextfield).sendKeys(email);
    return this;
  }

  public ContactPage setTelephone(String telephone) {
    driver.findElement(telephoneTextfield).sendKeys(telephone);
    return this;
  }

  public ContactPage setMessage(String message) {
    driver.findElement(messageTextfield).sendKeys(message);
    return this;
  }

  public String getSuccessMessage() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    return wait
      .until(ExpectedConditions.visibilityOfElementLocated(successMessage))
      .getText();
  }
}
