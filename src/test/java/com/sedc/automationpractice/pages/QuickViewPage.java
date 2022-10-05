package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class QuickViewPage {
    WebDriver driver;
    WebDriverWait wait;
    By qckView = By.cssSelector("ul.product_list div.product-image-container");
    By qckViewName = By.xpath("//h1[@itemprop='name']");
    By qckViewPrice = By.id("our_price_display");
    By iFrame = By.className("fancybox-iframe");
    By qckViewQuantity = By.id("quantity_wanted");
    By qckViewSize = By.id("group_1");
    By qckViewAddToCart = By.className("exclusive");
    By qckViewClose = By.xpath("//a[@title='Close']");
    By cartLayer = By.cssSelector("div#layer_cart");
    public QuickViewPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void qckViewProduct(int index) {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(qckView));
        products.get(index).click();
    }

    public void switchQckView (){
        driver.switchTo().frame(wait.until(ExpectedConditions.visibilityOfElementLocated(iFrame)));
    }

    public void qckViewQuantity (String quantity){
        wait.until(ExpectedConditions.visibilityOfElementLocated(qckViewQuantity)).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(qckViewQuantity)).sendKeys(quantity);
    }

    public void qckViewSize (String size){
        Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(qckViewSize)));
        select.selectByVisibleText(size);
    }

    public void qckViewAddToCart () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(qckViewAddToCart)).click();
        driver.switchTo().parentFrame();
    }

    public void switchParent (){
        driver.switchTo().parentFrame();
    }

    public void qckViewClose (){
        driver.switchTo().parentFrame();
        wait.until(ExpectedConditions.visibilityOfElementLocated(qckViewClose)).click();
    }

    public boolean checkCartLayer (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(cartLayer)).isDisplayed();
    }

}
