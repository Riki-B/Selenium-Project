package com.sedc.automationpractice.tests;

import org.testng.annotations.Test;

public class QuickViewPageTest extends BaseTest{
    String size = "M";
    String quantity = "7";
    String[] color = new String[5];

    @Test
    public void quickView (){
        homePage.navigateToPage();
        homePage.selectWomen();
        quickViewPage.qckViewProduct(1);
        quickViewPage.switchQckView();
        quickViewPage.qckViewQuantity(quantity);
        quickViewPage.qckViewSize(size);
        viewProductPage.getColor(0);
        quickViewPage.qckViewAddToCart();
        color[0] = categoriesPage.productColor();
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.productQuant(0),quantity, "Quantity of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productSize(0), size);
        softAssert.assertEquals(checkOutSummaryPage.productColor(0), color[0]);
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 1);
        softAssert.assertAll();
    }

    @Test
    public void quickViewClose (){
        homePage.navigateToPage();
        homePage.selectWomen();
        quickViewPage.qckViewProduct(3);
        quickViewPage.switchQckView();
        quickViewPage.qckViewQuantity(quantity);
        quickViewPage.qckViewSize(size);
        viewProductPage.getColor(0);
        quickViewPage.qckViewClose();
        quickViewPage.qckViewProduct(6);
        quickViewPage.switchQckView();
        viewProductPage.getColor(0);
        quickViewPage.qckViewQuantity(quantity);
        quickViewPage.qckViewSize(size);
        viewProductPage.getColor(0);
        quickViewPage.qckViewAddToCart();
        color[0] = categoriesPage.productColor();
        categoriesPage.proceedCheckOut();
        softAssert.assertEquals(checkOutSummaryPage.productQuant(0),quantity, "Quantity of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productQuant(0),quantity, "Quantity of this product is not correct");
        softAssert.assertEquals(checkOutSummaryPage.productSize(0), size);
        softAssert.assertEquals(checkOutSummaryPage.productColor(0), color[0]);
        softAssert.assertEquals(checkOutSummaryPage.checkNumberOfCartItems(), 1);
        softAssert.assertAll();
    }

    @Test (description = "Check if product is added to cart with negative quantity")
    public void quickViewQuantity(){
        homePage.navigateToPage();
        homePage.selectWomen();
        quickViewPage.qckViewProduct(1);
        quickViewPage.switchQckView();
        quickViewPage.qckViewQuantity("-5");
        quickViewPage.qckViewSize(size);
        viewProductPage.getColor(0);
        quickViewPage.qckViewAddToCart();
        softAssert.assertFalse(quickViewPage.checkCartLayer());
        softAssert.assertAll();
    }

}
