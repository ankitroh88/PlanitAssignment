package com.planit.application.utilities;

import com.planit.application.data.ContactData;
import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {

  @DataProvider(name = "ContactsData")
  public Object[][] getAllData() throws IOException {
    String csvfilepath = "src\\test\\java\\com\\planit\\application\\data\\Userdata.xlsx";
    XLUtility xl = new XLUtility(csvfilepath);
    int rownum = xl.getRowCount("Sheet1");
    Object[][] data = new Object[rownum][1];

    for (int i = 1; i <= rownum; i++) {
      String forename = xl.getCellData("Sheet1", i, 0);
      String surname = xl.getCellData("Sheet1", i, 1);
      String email = xl.getCellData("Sheet1", i, 2);
      String telephone = xl.getCellData("Sheet1", i, 3);
      String message = xl.getCellData("Sheet1", i, 4);

      ContactData contactData = new ContactData(
        forename,
        surname,
        email,
        telephone,
        message
      );

      data[i - 1][0] = contactData;
    }

    return data;
  }
}
