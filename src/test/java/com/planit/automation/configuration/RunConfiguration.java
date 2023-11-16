package com.planit.automation.configuration;

public class RunConfiguration {

  private static final String browser = "chrome";
  private static final int implicitwait = 10;
  private static final int pageloadwait = 30;
  private static final String applicationurl =
    "http://jupiter.cloud.planittesting.com";

  public static String getBrowser() {
    return browser;
  }

  public static int getImplicitWait() {
    return implicitwait;
  }

  public static int getPageLoadWait() {
    return pageloadwait;
  }

  public static String getUrl() {
    return applicationurl;
  }
}
