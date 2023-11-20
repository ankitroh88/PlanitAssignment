package com.planit.application.tests;

import com.planit.application.pages.HomePage;
import com.planit.application.pages.ShopPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest {

  ShopPage shopPage;
  String stuffedFrogUnitPrice = "10.99";
  int stuffedFrogQuantity = 2;
  String fluffyBunnyUnitPrice = "9.99";
  int fluffyBunnyQuantity = 5;
  String valentineBearUnitPrice = "14.99";
  int valentineBearQuantity = 3;
  String expectedSubtotalStuffedFrog = "";
  String expectedSubtotalFluffyBunny = "";
  String expectedSubtotalValentineBear = "";
  double expectedCartTotal = 0;

  @BeforeMethod
  public void TestSetup() throws Exception {
    shopPage = new HomePage(driver).clickShopMenu();
  }

  @Test(priority = 1)
  public void addItemsToCart() throws Exception {
    System.out.println("Validating Test Case 3 - Adding items to cart.");

    shopPage
      .addItemToCart("Stuffed Frog")
      .addItemToCart("Stuffed Frog")
      .addItemToCart("Fluffy Bunny")
      .addItemToCart("Fluffy Bunny")
      .addItemToCart("Fluffy Bunny")
      .addItemToCart("Fluffy Bunny")
      .addItemToCart("Fluffy Bunny")
      .addItemToCart("Valentine Bear")
      .addItemToCart("Valentine Bear")
      .addItemToCart("Valentine Bear")
      .goToCart();

    Assert.assertEquals(
      stuffedFrogUnitPrice,
      shopPage.getItemUnitPriceInCart("Stuffed Frog")
    );
    Assert.assertEquals(
      fluffyBunnyUnitPrice,
      shopPage.getItemUnitPriceInCart("Fluffy Bunny")
    );
    Assert.assertEquals(
      valentineBearUnitPrice,
      shopPage.getItemUnitPriceInCart("Valentine Bear")
    );
    System.out.println("Items unit price in cart validated successfully.");

    expectedSubtotalStuffedFrog =
      shopPage.getExpectedSubtotal("Stuffed Frog", stuffedFrogQuantity);

    expectedSubtotalFluffyBunny =
      shopPage.getExpectedSubtotal("Fluffy Bunny", fluffyBunnyQuantity);

    expectedSubtotalValentineBear =
      shopPage.getExpectedSubtotal("Valentine Bear", valentineBearQuantity);

    expectedCartTotal =
      Double.parseDouble(expectedSubtotalStuffedFrog) +
      Double.parseDouble(expectedSubtotalFluffyBunny) +
      Double.parseDouble(expectedSubtotalValentineBear);

    Assert.assertEquals(
      expectedSubtotalStuffedFrog,
      shopPage.getItemSubtotalInCart("Stuffed Frog")
    );
    Assert.assertEquals(
      expectedSubtotalFluffyBunny,
      shopPage.getItemSubtotalInCart("Fluffy Bunny")
    );
    Assert.assertEquals(
      expectedSubtotalValentineBear,
      shopPage.getItemSubtotalInCart("Valentine Bear")
    );
    System.out.println("Items subtotal price in cart validated successfully.");

    Assert.assertEquals(
      Double.toString(expectedCartTotal),
      shopPage.getCartTotal()
    );
    System.out.println("Items total price in cart validated successfully.");
  }
}
