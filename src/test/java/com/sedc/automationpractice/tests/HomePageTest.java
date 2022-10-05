package com.sedc.automationpractice.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageTest extends BaseTest{

    @Test
    public void checkCategories (){
        homePage.navigateToPage();
        homePage.selectTops();
        softAssert.assertEquals(homePage.getCatName(), "TOPS ");
        homePage.selectTShirt();
        softAssert.assertEquals(homePage.getCatName(), "T-SHIRTS ");
        homePage.selectBlouses();
        softAssert.assertEquals(homePage.getCatName(), "BLOUSES ");
        homePage.selectWomDress();
        softAssert.assertEquals(homePage.getCatName(), "DRESSES ");
        homePage.selectWomCasDress();
        softAssert.assertEquals(homePage.getCatName(), "CASUAL DRESSES ");
        homePage.selectWomEvnDress();
        softAssert.assertEquals(homePage.getCatName(), "EVENING DRESSES ");
        homePage.selectWomSumDress();
        softAssert.assertEquals(homePage.getCatName(), "SUMMER DRESSES ");
        softAssert.assertAll();
    }

}
