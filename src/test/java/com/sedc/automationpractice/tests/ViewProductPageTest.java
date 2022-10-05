package com.sedc.automationpractice.tests;

import org.testng.annotations.Test;

public class ViewProductPageTest extends BaseTest{
    String productQt = "5000000000";

    @Test (description = "check if product is added by adding negative quantity")
    public void checkQuantity(){
        homePage.navigateToPage();
        homePage.selectWomen();
        scrollDown(500);
        categoriesPage.viewProduct(2);
        viewProductPage.productQuantity("-1");
        viewProductPage.size("M");
        viewProductPage.addToCart();
        softAssert.assertFalse(viewProductPage.checkAddToCart());
        softAssert.assertAll();
    }

    @Test (description = "check if product is added by adding invalid quantity")
    public void checkQuantity2(){
        homePage.navigateToPage();
        homePage.selectWomen();
        scrollDown(500);
        categoriesPage.viewProduct(2);
        viewProductPage.productQuantity("Z");
        viewProductPage.size("M");
        viewProductPage.addToCart();
        softAssert.assertTrue(viewProductPage.checkAddToCartChar());
        softAssert.assertAll();
    }

    @Test (description = "check if product is added by adding large amount quantity")
    public void checkQuantity3(){
        homePage.navigateToPage();
        homePage.selectWomen();
        scrollDown(500);
        categoriesPage.viewProduct(2);
        viewProductPage.productQuantity(productQt);
        viewProductPage.size("M");
        viewProductPage.addToCart();
        softAssert.assertEquals(viewProductPage.checkQt(), productQt, "The maximum amount is lowered to 4294967295");
        softAssert.assertAll();
    }

    @Test (description = "continue shopping")
    public void continueShopping(){
        homePage.navigateToPage();
        homePage.selectWomen();
        scrollDown(500);
        categoriesPage.viewProduct(2);
        viewProductPage.addToCart();
        viewProductPage.continueShopping();
        softAssert.assertFalse(viewProductPage.checkNewPage());
        softAssert.assertAll();
    }

}
