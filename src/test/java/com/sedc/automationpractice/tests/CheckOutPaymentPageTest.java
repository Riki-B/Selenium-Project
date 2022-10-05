package com.sedc.automationpractice.tests;

import org.testng.annotations.Test;

public class CheckOutPaymentPageTest extends BaseTest{

    @Test (description = "Check if wire transfer is succ")
    public void wireTransfer (){
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
        checkOutAddressPage.proceed();
        checkOutPaymentPage.wire();
        softAssert.assertEquals(checkOutPaymentPage.checkPayment(), "BANK-WIRE PAYMENT.", "Bank-wire is not chosen");
        checkOutAddressPage.proceed();
        softAssert.assertEquals(checkOutPaymentPage.checkOrderBank(), "Your order on My Store is complete.", "Order not processed");
        softAssert.assertAll();
    }

    @Test (description = "Check if check payment is succ")
    public void checkPayment (){
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
        checkOutAddressPage.proceed();
        checkOutPaymentPage.check();
        softAssert.assertEquals(checkOutPaymentPage.checkPayment(), "CHECK PAYMENT", "Check payment is not chosen");
        checkOutAddressPage.proceed();
        softAssert.assertEquals(checkOutPaymentPage.checkOrderCheck(), "Your order on My Store is complete.", "Order not processed");
        softAssert.assertAll();
    }

}
