package com.sedc.automationpractice.tests;

import com.sedc.automationpractice.units.EndToEndDataProvider;
import org.testng.annotations.Test;

public class CheckOutAddressPageTest extends BaseTest{
    String getState = "";

    @Test(dataProvider = "Gender (0 = Mr, 1 = Mrs), Name, LastName, Password, DateOfBirth (dd,mm,yyyy), address, City, State (int), Zip, Number, Quantity, Size", dataProviderClass = EndToEndDataProvider.class)
    public void shippingAddress (int gender, String name, String lastName, String password, int day, int month, int year, String address, String city, int state, String zip, String num, String quantity, String size){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.selectGender(gender);
        createUserPage.enterName(name);
        createUserPage.lastName(lastName);
        createUserPage.password(password);
        createUserPage.selectDay(day);
        createUserPage.selectMonth(month);
        createUserPage.selectYear(year);
        createUserPage.enterAddress(address);
        createUserPage.enterCity(city);
        createUserPage.selectState(state);
        getState = createUserPage.getState(state);
        createUserPage.enterZip(zip);
        createUserPage.enterNumber(num);
        createUserPage.setSubmit();
        homePage.selectWomen();
        categoriesPage.addProductToCart(4);
        categoriesPage.proceedCheckOut();
        checkOutSummaryPage.proceed();
        softAssert.assertEquals(checkOutAddressPage.delName(), name, "Delivery name is not correct");
        softAssert.assertEquals(checkOutAddressPage.delLastName(), lastName, "Delivery last name is not correct");
        softAssert.assertEquals(checkOutAddressPage.delAd(), address, "Delivery address is not correct");
        softAssert.assertEquals(checkOutAddressPage.deliveryCityStateZip(), city+", "+getState+" "+zip, "Delivery City State and ZIP are not correct");
        softAssert.assertEquals(checkOutAddressPage.delNum(), num, "Delivery number is not correct");
        softAssert.assertEquals(checkOutAddressPage.invName(), name, "Invoice name is not correct");
        softAssert.assertEquals(checkOutAddressPage.invLastName(), lastName, "Invoice last name is not correct");
        softAssert.assertEquals(checkOutAddressPage.invAd(), address, "Invoice address is not correct");
        softAssert.assertEquals(checkOutAddressPage.invoiceCityStateZip(), city+", "+getState+" "+zip, "Invoice City State and ZIP are not correct");
        softAssert.assertEquals(checkOutAddressPage.invNum(), num, "Invoice number is not correct");
        softAssert.assertAll();
    }

}
