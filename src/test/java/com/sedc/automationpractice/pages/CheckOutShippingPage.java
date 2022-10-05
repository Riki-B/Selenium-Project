package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutShippingPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    By terms = By.xpath("//label[@for='cgv']");
    By error = By.className("fancybox-inner");
    By checkBox = By.cssSelector(".checker .checked");
    By errorClose = By.xpath("//a[@title='Close']");


    public CheckOutShippingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void terms (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(terms)).click();
    }

    public boolean checkTerms (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkBox)).isEnabled();
    }

    public boolean checkError(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).isDisplayed();
    }

    public void errorClose (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorClose)).click();
    }

}
