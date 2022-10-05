package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPaymentPage {
    WebDriver driver;
    WebDriverWait wait;
    By wire = By.className("bankwire");
    By check = By.className("cheque");
    By checkPayment = By.className("page-subheading");
    By checkOrderCheck = By.className("alert-success");
    By checkOrderBank = By.className("cheque-indent");
    By orderID = By.xpath("//*[@id=\"center_column\"]/div/text()[8]");

    public CheckOutPaymentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void wire (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(wire)).click();
    }

    public void check (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(check)).click();
    }

    public String checkPayment (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkPayment)).getText();
    }

    public String checkOrderBank (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkOrderBank)).getText();
    }

    public String checkOrderCheck (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkOrderCheck)).getText();
    }

}
