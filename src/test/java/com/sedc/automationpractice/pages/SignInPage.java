package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    By createEmail = By.id("email_create");
    By createBut = By.id("SubmitCreate");
    By errorMsg = By.id("create_account_error");
    By signInEmail = By.id("email");
    By signInPass = By.id("passwd");
    By signInError = By.xpath("//div[@id='center_column']/div[contains(@class,'alert')]");
    By signInButt = By.id("SubmitLogin");
    By checkUser = By.className("account");


    public SignInPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void createAddEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createEmail)).sendKeys(email);
    }

    public void createButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(createBut)).click();
    }

    public boolean checkErrorMessage() {
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).isDisplayed())
            return true;
        else
            return false;
    }

    public void signInEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInEmail)).sendKeys(email);
    }

    public void signInPass(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInPass)).sendKeys(pass);
    }

    public boolean checkSignInErrorMessage() {
        if (wait.until(ExpectedConditions.visibilityOfElementLocated(signInError)).isDisplayed())
            return true;
        else return false;
    }

    public void signIn () {
        wait.until(ExpectedConditions.visibilityOfElementLocated(signInButt)).click();
    }

    public boolean checkCreatePage (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("noSlide"))).isDisplayed();
    }

    public boolean checkSingInPage (){
        return driver.getCurrentUrl().equalsIgnoreCase("http://automationpractice.com/index.php?controller=my-account");
    }

    public String checkUsername (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(checkUser)).getText();
    }

}
