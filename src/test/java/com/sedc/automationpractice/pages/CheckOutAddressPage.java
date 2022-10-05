package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutAddressPage {
    WebDriver driver;
    WebDriverWait wait;

    By delAdd = By.id("address_delivery");
    By invAdd = By.id("address_invoice");
    By nameLastName = By.className("address_firstname");
    By address = By.className("address_address1");
    By city = By.className("address_city");
    By number = By.className("address_phone_mobile");
    By continueShopping = By.xpath("//p[@class='cart_navigation clearfix']//a");
    By proceed = By.xpath("//p[@class='cart_navigation clearfix']//button");


    public CheckOutAddressPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String delName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(delAdd)).findElement(nameLastName).getText();
        String[] name = temp.split("\\s");
        return name[0];
    }

    public String delLastName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(delAdd)).findElement(nameLastName).getText();
        String[] lastName = temp.split("\\s");
        return lastName[1];
    }

    public String delAd (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(delAdd)).findElement(address).getText();
    }

    public String deliveryCityStateZip (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(delAdd)).findElement(this.city).getText();
    }

    public String invoiceCityStateZip(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(delAdd)).findElement(this.city).getText();
    }

    public String delNum (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(delAdd)).findElement(number).getText();
    }

    public String invName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(invAdd)).findElement(nameLastName).getText();
        String[] name = temp.split("\\s");
        return name[0];
    }

    public String invLastName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(invAdd)).findElement(nameLastName).getText();
        String[] lastName = temp.split("\\s");
        return lastName[1];
    }

    public String invAd (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invAdd)).findElement(address).getText();
    }

    public String invCityState (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invAdd)).findElement(city).getText();
    }

    public String invNum (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invAdd)).findElement(number).getText();
    }

    public void continueShopping (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).click();
    }

    public void proceed (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceed)).click();
    }

}
