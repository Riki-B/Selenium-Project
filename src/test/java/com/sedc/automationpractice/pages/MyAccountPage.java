package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url = "http://automationpractice.com/index.php?controller=my-account";
    By categories = By.className("sf-menu");
    By catWomen = By.xpath("//a[@title='Women']");
    By catDress = By.tagName("li[2]");
    By catTShirt = By.tagName("li[3]");
    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void selectTshirt (){
        WebElement women = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen);
        WebElement tShirt = wait.until(ExpectedConditions.visibilityOfElementLocated(categories)).findElement(catWomen).findElement(By.cssSelector("a[title='T-shirts']"));
        actions.moveToElement(women).moveToElement(tShirt).click().perform();
    }


}
