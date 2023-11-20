package com.planit.application.tests;

import com.github.javafaker.Faker;
import com.planit.application.data.ContactData;
import com.planit.application.pages.ContactPage;
import com.planit.application.pages.HomePage;
import com.planit.application.utilities.DataProviders;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactTest extends BaseTest {

  ContactPage contactPage;
  String firstName;
  String serialNumber;
  String successMsg;

  @BeforeMethod
  public void TestSetup() throws Exception {
    contactPage = new HomePage(driver).clickContactMenu();
  }

  @Test(priority = 1)
  public void validateMandatoryFieldsErrors() {
    contactPage.clickSubmitButton();
    System.out.println(
      "Validating Test Case 1 - Submission done on Contact page without entering mandatory dataset."
    );
    Assert.assertEquals(
      contactPage.getForenameError(),
      "Forename is required"
    );
    Assert.assertEquals(contactPage.getEmailError(), "Email is required");
    Assert.assertEquals(
      contactPage.getMessageError(),
      "Message is required"
    );
    System.out.println(
      "Error message wrt empty mandatory fields validated successfully - Pass."
    );
  }

  @Test(priority = 2)
  public void validateMandatoryFieldsErrorFix() {
    System.out.println(
      "Validating Test Case 1 - errors should go away on providing data for mandatory fields."
    );
    Faker faker = new Faker();
    contactPage
      .clickSubmitButton()
      .setForename(faker.name().firstName())
      .setEmail(faker.internet().emailAddress())
      .setMessage(faker.name().lastName());
    Assert.assertEquals(contactPage.getForenameError(), "");
    Assert.assertEquals(contactPage.getEmailError(), "");
    Assert.assertEquals(contactPage.getMessageError(), "");
    System.out.println(
      "Error message wrt mandatory fields gone on providing input - Pass."
    );
  }

  @Test(
    priority = 3,
    dataProvider = "ContactsData",
    dataProviderClass = DataProviders.class
  )
  public void validateSuccessfulContactSubmissionUsingXLS(
    ContactData contactData
  ) {
    System.out.println(
      "Validating Test Case 2 - successful submission of data on Contact page."
    );

    firstName = contactData.getForename();

    contactPage
      .setForename(contactData.getForename())
      .setSurname(contactData.getSurname())
      .setEmail(contactData.getEmail())
      .setTelephone(contactData.getTelephone())
      .setMessage(contactData.getMessage())
      .clickSubmitButton();

    successMsg = contactPage.getSuccessMessage();
    Assert.assertEquals(
      "Thanks " + firstName + ", we appreciate your feedback.",
      successMsg
    );
  }
}
