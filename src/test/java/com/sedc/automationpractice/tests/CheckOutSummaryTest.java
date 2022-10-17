package com.sedc.automationpractice.tests;

import org.testng.annotations.Test;

public class CheckOutSummaryTest extends BaseTest{
    String[] pName = new String[5];
    String[] price = new String[5];
    String[] totalPrice = new String[5];
    String[] color = new String[5];
    String quantity = "10";
    String size = "M";

    @Test (description = "check if one product is added")
    public void addProduct (){
        homePage.navigateToPage();
        homePage.selectWomen();
        categoriesPage.addProductToCart(4);
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 1, "Number of items is not correct after deletion");
        softAssert.assertAll();
    }

    @Test (description = "check if multiple products are added")
    public void addProducts (){
        homePage.navigateToPage();
        homePage.selectWomen();
        categoriesPage.addProductToCart(4);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(0);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(2);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(1);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(6);
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 5, "Number of items is not correct after deletion");
        softAssert.assertAll();
    }

    @Test (description = "check if multiple products are added")
    public void deleteProduct (){
        homePage.navigateToPage();
        homePage.selectWomen();
        categoriesPage.addProductToCart(4);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(0);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(2);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(1);
        categoriesPage.continueShopping();
        categoriesPage.addProductToCart(6);
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 5, "Number of items is not correct after deletion");
        checkOutSummaryPage.deleteProduct(0);
        sleep(5000);
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 4, "Number of items is not correct after deletion");
        softAssert.assertAll();
    }

    @Test (description = "Check total price calculation (without tax and shipping)")
    public void totalPrice (){
        homePage.navigateToPage();
        homePage.selectWomen();
        scrollDown(500);
        pName[0] = categoriesPage.getProductName(1);
        price[0] = categoriesPage.getProductPrice(1);
        quickViewPage.qckViewProduct(1);
        quickViewPage.switchQckView();
        quickViewPage.qckViewQuantity(quantity);
        quickViewPage.qckViewSize(size);
        viewProductPage.color(1);
        quickViewPage.qckViewAddToCart();
        color[0] = categoriesPage.productColor();
        categoriesPage.continueShopping();
        pName[1] = categoriesPage.getProductName(0);
        price[1] = categoriesPage.getProductPrice(0);
        quickViewPage.qckViewProduct(0);
        quickViewPage.switchQckView();
        quickViewPage.qckViewQuantity(quantity);
        quickViewPage.qckViewSize(size);
        viewProductPage.color(0);
        quickViewPage.qckViewAddToCart();
        color[1] = categoriesPage.productColor();
        categoriesPage.continueShopping();
        pName[2] = categoriesPage.getProductName(4);
        price[2] = categoriesPage.getProductPrice(4);
        scrollDown(500);
        categoriesPage.viewProduct(4);
        viewProductPage.productQuantity("10");
        viewProductPage.size(size);
        viewProductPage.color(1);
        viewProductPage.addToCart();
        color[2] = categoriesPage.productColor();
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 3, "Total products in cart is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productPrice(0),price[0], "Price of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productPrice(1),price[1], "Price of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productPrice(2),price[2], "Price of this product is not correct");
        totalPrice[0] = checkOutSummaryPage.totalProdPriceCal(price[0],quantity);
        totalPrice[1] = checkOutSummaryPage.totalProdPriceCal(price[1],quantity);
        totalPrice[2] = checkOutSummaryPage.totalProdPriceCal(price[2],"10");
        softAssert.assertEquals(checkOutSummaryPage.productTotalPrice(0), totalPrice[0], "Total price of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productTotalPrice(1), totalPrice[1], "Total price of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productTotalPrice(2), totalPrice[2], "Total price of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.totalPrice(), checkOutSummaryPage.totalPriceCal(totalPrice), "Total price of all products is not the same");
        softAssert.assertAll();
    }

    @Test (description = "Check quantity change")
    public void changeQuantity(){
        homePage.navigateToPage();
        homePage.selectWomen();
        scrollDown(1000);
        categoriesPage.viewProduct(4);
        viewProductPage.productQuantity("7");
        viewProductPage.addToCart();
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.productQuant(0), "7", "Product quantity does not match");
        checkOutSummaryPage.setQuantity(0, "3");
        softAssert.assertEquals(checkOutSummaryPage.productQuant(0), "3", "Product quantity does not match");
        softAssert.assertAll();
    }

}
