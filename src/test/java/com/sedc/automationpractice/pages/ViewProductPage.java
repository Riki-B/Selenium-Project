package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewProductPage {
    WebDriver driver;
    WebDriverWait wait;
    By productName = By.xpath("//h1");
    By productPrice = By.id("our_price_display");
    By productQuant = By.id("quantity_wanted");
    By productSize = By.id("group_1");
    By addToCart = By.cssSelector("button.exclusive");
    By visibilityShopp = By.id("layer_cart");
    By error = By.className("fancybox-error");
    By checkQt = By.id("layer_cart_product_quantity");
    By continueShopping = By.xpath("//div[@class='button-container']/span");
    By proceedCheckOut = By.xpath("//div[@class='button-container']/a");
    By color = By.xpath("//ul[@id='color_to_pick_list']/li");

    public ViewProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String productName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
    }

    public String productPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice)).getText().substring(1);
    }

    public void productQuantity(String quantity) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuant)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(productQuant)).sendKeys(quantity);
    }

    // select again not working, don't know why
    public void productSize(String size) {
        Select pSize = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(productSize)));
        pSize.selectByVisibleText(size);
    }

    public void size(String size) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='group_1']/option[text()='" + size + "']"))).click();
    }

    public void color (int index){
        List< WebElement> pColor = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(color));
        pColor.get(index).click();

    }

    public String getColor (int index){
        List< WebElement> pColor = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(color));
        return pColor.get(index).getAttribute("title");
    }



    public void addToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).click();
    }

    public boolean checkAddToCart (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(visibilityShopp)).isDisplayed();
    }

    public boolean checkAddToCartChar (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(error)).isDisplayed();
    }

    public String checkQt (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkQt)).getText();
    }

    public void continueShopping (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).click();
    }

    public void proceedCheckOut (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedCheckOut)).click();
    }

    public boolean checkNewPage (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart)).isDisplayed();
    }

}
