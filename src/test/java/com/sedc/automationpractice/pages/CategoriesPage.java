package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoriesPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    By products = By.cssSelector("ul.product_list div.product-container");
    By addToCart = By.cssSelector("a.ajax_add_to_cart_button");
    By viewProduct = By.cssSelector("a.lnk_view");
    By continueShop = By.cssSelector("span.continue");
    By checkOut = By.xpath("//a[@title='Proceed to checkout']");
    By productName = By.cssSelector("ul.product_list a.product-name");
    By productPrice = By.cssSelector("div.right-block div.content_price");
    By productColor = By.id("layer_cart_product_attributes");

    public CategoriesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void addProductToCart(int index) {
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.products));
        actions.moveToElement(products.get(index)).perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$(arguments[0]).click();", products.get(index).findElement(addToCart));
    }

    public String getProductPrice (int index) {
        List<WebElement> price = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrice));
        return price.get(index).getText().substring(1,6);
    }

    public String getProductName (int index) {
        List<WebElement> pName = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productName));
        return pName.get(index).getText();
    }

    // Must scroll so that the product is displayed halfway and can be clicked
    public void viewProduct(int index) {
        List<WebElement> dresses = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(products));
        dresses.get(index).click();
    }

    public void continueShopping() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShop)).click();
    }

    public void proceedCheckOut() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkOut)).click();
    }

    public String productColor (){
        String[] tmp = wait.until(ExpectedConditions.visibilityOfElementLocated(productColor)).getText().split(",");
        return tmp[0];
    }

}
