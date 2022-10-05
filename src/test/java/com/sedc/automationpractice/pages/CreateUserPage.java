package com.sedc.automationpractice.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;
import java.util.UUID;

import static com.sedc.automationpractice.tests.BaseTest.js;

public class CreateUserPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    By gender = By.xpath("//label[@class='top']/div/span");
    By firstName = By.id("customer_firstname");
    By lastName = By.id("customer_lastname");
    By password = By.id("passwd");
    By selectDay = By.id("days");
    By month = By.id("months");
    By year = By.id("years");
    By checkName = By.id("firstname");
    By checkLastName = By.id("lastname");
    By enterAddress = By.id("address1");
    By city = By.id("city");
    By state = By.id("//*[@id='uniform-id_state']/select");
    By zipCode = By.id("postcode");
    By country = By.id("id_country");
    By number = By.id("phone_mobile");
    By submit = By.id("submitAccount");
    By alert = By.className("alert-danger");
    By email = By.id("email");

    public CreateUserPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        actions = new Actions(driver);
    }

    public void selectGender(int index) {
        List<WebElement> gender = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(this.gender));
        gender.get(index).click();
    }

    public void enterName(String name) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName)).sendKeys(name);
    }

    public void lastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.lastName)).sendKeys(lastName);
    }

    public void password(String password) {
        if (password.length() < 5) {
            System.out.println("Please enter at least 5 characters");
        } else
            wait.until(ExpectedConditions.visibilityOfElementLocated(this.password)).sendKeys(password);
    }

    public void selectDay(int day) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='days']/option[@value='"+day+"']"))).click();
    }

    public void selectMonth(int month) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='months']/option[@value='"+month+"']"))).click();
    }

    public void selectYear(int year) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='years']/option[@value='"+year+"']"))).click();
    }

    public void enterAddress(String address) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(enterAddress)).sendKeys(address);
    }

    public void enterCity(String city) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.city)).sendKeys(city);
    }

    public void selectState(int index) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='uniform-id_state']/select/option[" + index + "]"))).click();
    }

    public String getState(int index){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='uniform-id_state']/select/option[" + index + "]"))).getText();
    }

    public void enterZip(String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(zipCode)).sendKeys(zip);
    }

    // select not working on creation page for some reason the same is for the birth dates selection
    public void selectCountry(int index) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(country)));
        select.selectByIndex(index);
    }

    public void enterNumber(String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(number)).sendKeys(phoneNumber);
    }

    public void setSubmit() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(submit)).click();
    }

    public boolean checkAlert (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(alert)).isDisplayed();
    }

    public boolean checkURL (){
        return driver.getCurrentUrl().equalsIgnoreCase("http://automationpractice.com/index.php?controller=authentication");
    }

    public String getEmail (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(email)).getAttribute("value");
    }

    public static String getUniqueId() {
        return String.format("%s_%s", UUID.randomUUID().toString().substring(0, 5), System.currentTimeMillis() / 1000);
    }

    public static String randomEmail() {
        return String.format("%s@%s", getUniqueId(), "example.com");
    }

}
