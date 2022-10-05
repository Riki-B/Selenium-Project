package com.sedc.automationpractice.tests;

import org.testng.annotations.Test;

public class CheckOutShippingPageTest extends BaseTest{

    @Test (description = "Check without agreeing if passes")
    public void checkErrorMessage (){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.signInEmail(createdEmail);
        signInPage.signInPass(pass);
        signInPage.signIn();
        homePage.selectWomen();
        categoriesPage.addProductToCart(2);
        categoriesPage.proceedCheckOut();
        checkOutSummaryPage.proceed();
        checkOutAddressPage.proceed();
        checkOutAddressPage.proceed();
        softAssert.assertTrue(checkOutShippingPage.checkError(), "Error message is not displayed");
        softAssert.assertAll();
    }

    @Test (description = "Check agree terms pass")
    public void checkAgree (){
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.signInEmail(createdEmail);
        signInPage.signInPass(pass);
        signInPage.signIn();
        homePage.selectWomen();
        categoriesPage.addProductToCart(2);
        categoriesPage.proceedCheckOut();
        checkOutSummaryPage.proceed();
        checkOutAddressPage.proceed();
        checkOutShippingPage.terms();
        softAssert.assertTrue(checkOutShippingPage.checkTerms(), "Terms are not checked");
        softAssert.assertAll();
    }

}
