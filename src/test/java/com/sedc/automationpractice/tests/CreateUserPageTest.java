package com.sedc.automationpractice.tests;

import com.sedc.automationpractice.units.CreateUserFormDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateUserPageTest extends BaseTest{
    String name = "Rottie";
    String lastName = "Dog";


    @Test (description = "Check if creation passes without entering several required field fields")
    public void checkCreationRequired(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.selectGender(0);
        createUserPage.enterName(name);
        createUserPage.lastName(lastName);
        createUserPage.password(pass);
        createUserPage.selectDay(10);
        createUserPage.selectMonth(1);
        createUserPage.selectYear(1990);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.enterZip("10000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkAlert());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes without adding alias address", dataProvider = "Gender (0 = Mr, 1 = Mrs), Name, LastName, Password, DateOfBirth (dd,mm,yyyy), address, City, State (int), Zip, Number", dataProviderClass = CreateUserFormDataProvider.class)
    public void checkCreation(int gender, String name, String lastName, String password, int day, int month, int year, String address, String city, int state, String zip, String num){
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
        createUserPage.enterZip(zip);
        createUserPage.enterNumber(num);
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkURL());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes")
    public void validCreation(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.selectGender(0);
        createUserPage.enterName(name);
        createUserPage.lastName(lastName);
        createUserPage.password(pass);
        createUserPage.selectDay(10);
        createUserPage.selectMonth(1);
        createUserPage.selectYear(1990);
        createUserPage.enterAddress("Test");
        createUserPage.selectState(3);
        createUserPage.enterCity("Bitola");
        createUserPage.enterZip("10000");
        createUserPage.enterNumber("0123456789");
        createUserPage.setSubmit();
        softAssert.assertEquals(signInPage.checkUsername(), name+" "+lastName);
        softAssert.assertFalse(createUserPage.checkURL());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes without entering name")
    public void checkCreationNoName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.lastName(lastName);
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkAlert());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes with number name")
    public void checkCreationNumberName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName("1");
        createUserPage.lastName(lastName);
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkAlert());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes with space name")
    public void checkCreationSpaceName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName(" ");
        createUserPage.lastName(lastName);
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkURL(), "Registration passes with space as a Name");
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes with dot name")
    public void checkCreationDotName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName(".");
        createUserPage.lastName(lastName);
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkURL());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes without entering name")
    public void checkCreationNoLastName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName(name);
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkAlert());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes with number name")
    public void checkCreationNumberLastName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName(name);
        createUserPage.lastName("1");
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkAlert());
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes with space name")
    public void checkCreationSpaceLastName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName(name);
        createUserPage.lastName(" ");
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkURL(), "Registration passes with space as a Last name");
        softAssert.assertAll();
    }

    @Test (description = "Check if creation passes with dot name")
    public void checkCreationDotLastName(){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        createUserPage.enterName(name);
        createUserPage.lastName(".");
        createUserPage.password(pass);
        createUserPage.enterAddress("Test");
        createUserPage.enterCity("Bitola");
        createUserPage.selectState(2);
        createUserPage.enterZip("00000");
        createUserPage.setSubmit();
        softAssert.assertTrue(createUserPage.checkURL());
        softAssert.assertAll();
    }



}
