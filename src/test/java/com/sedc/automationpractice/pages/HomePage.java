package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url = "http://automationpractice.com/index.php";
    By signInBut = By.cssSelector("a.login");
    By categories = By.className("sf-menu");
    By catWomen = By.xpath("//a[@title='Women']");
    By womTops = By.xpath("//a[@title='Tops']");
    By tShirt = By.xpath("//a[@title='T-shirts']");
    By womBlouses = By.xpath("//a[@title='Blouses']");
    By casDress = By.xpath("//a[@title='Casual Dresses']");
    By evnDress = By.xpath("//a[@title='Evening Dresses']");
    By sumDress = By.xpath("//a[@title='Summer Dresses']");
    By catDress = By.xpath("//a[@title='Dresses']");
    By catName = By.className("cat-name");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void navigateToSignIn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInBut)).click();
    }

    public void selectWomen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).click();
    }

    public void selectBlouses() {
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement blouse = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(womBlouses);
        actions.moveToElement(women).moveToElement(blouse).click().perform();
    }

    public void selectTShirt() {
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement tShirt = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(this.tShirt);
        actions.moveToElement(women).moveToElement(tShirt).click().perform();
    }

    public void selectTops (){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement tops = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(womTops);
        actions.moveToElement(women).moveToElement(tops).click().perform();
    }

    public void selectWomDress (){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement dress = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(catDress);
        actions.moveToElement(women).moveToElement(dress).click().perform();
    }

    public void selectWomCasDress (){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement casDress = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(this.casDress);
        actions.moveToElement(women).moveToElement(casDress).click().perform();
    }

    public void selectWomEvnDress (){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement evnDress = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(this.evnDress);
        actions.moveToElement(women).moveToElement(evnDress).click().perform();
    }

    public void selectWomSumDress (){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement sumDress = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(this.sumDress);
        actions.moveToElement(women).moveToElement(sumDress).click().perform();
    }

    public String getCatName (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(catName)).getText();
    }

}
