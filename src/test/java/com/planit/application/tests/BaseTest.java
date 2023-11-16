package com.planit.application.tests;

import com.planit.automation.configuration.RunConfiguration;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

  protected WebDriver driver;

  @BeforeMethod
  public void BaseSetup() throws Exception {
    String browser = RunConfiguration.getBrowser();
    int implicitwait = RunConfiguration.getImplicitWait();
    int pageloadwait = RunConfiguration.getPageLoadWait();
    String url = RunConfiguration.getUrl();
    switch (browser.toLowerCase()) {
      case "chrome":
        ChromeOptions chromeoptions = new ChromeOptions();
        chromeoptions.addArguments("disable-infobars");
        chromeoptions.addArguments("--disable-notifications");
        driver = new ChromeDriver(chromeoptions);
        break;
      case "firefox":
        FirefoxOptions firefoxoptions = new FirefoxOptions();
        firefoxoptions.addArguments("--disable-notifications");
        driver = new FirefoxDriver(firefoxoptions);
        break;
      case "edge":
        EdgeOptions edgeoptions = new EdgeOptions();
        edgeoptions.addArguments("inprivate");
        driver = new EdgeDriver(edgeoptions);
        break;
      default:
        throw new Exception("Unsupported browser: " + browser);
    }

    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitwait));
    driver
      .manage()
      .timeouts()
      .pageLoadTimeout(Duration.ofSeconds(pageloadwait));
    driver.get(url);
  }

  @AfterMethod
  public void BaseTearDown() {
    driver.quit();
  }
}
