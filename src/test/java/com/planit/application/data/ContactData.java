package com.planit.application.data;

public class ContactData {

  private String forename;
  private String surname;
  private String email;
  private String telephone;
  private String message;

  public ContactData(
    String forename,
    String surname,
    String email,
    String telephone,
    String message
  ) {
    this.forename = forename;
    this.surname = surname;
    this.email = email;
    this.telephone = telephone;
    this.message = message;
  }

  public ContactData() {
    this.forename = "Ankit";
    this.surname = "Rohilla";
    this.email = "ar@gmail.com";
    this.telephone = "123456789";
    this.message = "Automation Test";
  }

  public String getForename() {
    return forename;
  }

  public void setForename(String forename) {
    this.forename = forename;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
