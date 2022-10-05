package com.sedc.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CheckOutSummaryPage {
    WebDriver driver;
    WebDriverWait wait;
    By cartItem = By.className("cart_item");
    By productName = By.className("product-name");
    By productPrice = By.xpath("//tr[contains(@class, 'cart_item')]//span[@class='price' and not(contains(@class, 'old-price'))][1]/span[1]");
    By productQuant = By.className("cart_quantity_input");
    By productTotalPrice = By.xpath("//span[starts-with(@id, 'total_product_price')]");
    By deleteProduct = By.className("icon-trash");
    By totalPrice = By.xpath("//tr[@class='cart_total_price']//td[@id='total_product']");
    By deliveryAdd = By.xpath("//ul[contains(@class, 'first_item')]");
    By invoiceAdd = By.xpath("//ul[contains(@class, 'last_item')]");
    By nameLastName = By.className("address_name");
    By address = By.className("address_address1");
    By city = By.className("address_city");
    By number = By.className("address_phone_mobile");
    By continueShopping = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Continue shopping']");
    By proceedToCheckOut = By.xpath("//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']");
    By size = By.xpath("//td[@class='cart_description']/small[2]");

    public CheckOutSummaryPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public int checkNumberOfCartItems (){
        List<WebElement> number = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItem));
        return number.size();
    }

    public String productName (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItem));
        return product.get(index).findElement(productName).getText();
    }

    public String productPrice (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrice));
        return product.get(index).getText().substring(1);
    }

    public String productQuant (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productQuant));
        return product.get(index).getAttribute("value");
    }

    public void setQuantity (int index, String qnt){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productQuant));
        product.get(index).clear();
        product.get(index).sendKeys(qnt);
    }

    public String productTotalPrice (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productTotalPrice));
        return product.get(index).getText().substring(1);
    }

    public void deleteProduct (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(deleteProduct));
        product.get(index).click();
    }

    public String totalPrice (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).getText().substring(1);
    }

    public String delName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(nameLastName).getText();
        String[] name = temp.split("\\s");
        return name[0];
    }

    public String delLastName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(nameLastName).getText();
        String[] lastName = temp.split("\\s");
        return lastName[1];
    }

    public String delAd (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(address).getText();
    }

    public String deliveryCityStateZip (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(this.city).getText();
    }

    public String invoiceCityStateZip(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceAdd)).findElement(this.city).getText();
    }

    // Not working due to the States including multiple words in name such as District of Colorado
//    public String delCity (){
//        String temp = "";
//        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(city).getText();
//        String[] city = temp.split(",");
//        return city[0];
//    }
//
//    public String delState (){
//        String temp = "";
//        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(city).getText();
//        String[] city = temp.split("\\s");
//        return city[1];
//    }
//
//    public String delZip (){
//        String temp = "";
//        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(city).getText();
//        String[] city = temp.split("\\s");
//        return city[2];
//    }

    public String delNum (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(number).getText();
    }

    public String invName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceAdd)).findElement(nameLastName).getText();
        String[] name = temp.split("\\s");
        return name[0];
    }

    public String invLastName (){
        String temp = "";
        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceAdd)).findElement(nameLastName).getText();
        String[] lastName = temp.split("\\s");
        return lastName[1];
    }

    public String invAd (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceAdd)).findElement(address).getText();
    }

    public String productSize (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItem));
        String temp = product.get(index).findElement(size).getText();
        String[] size = temp.split(":");
        return size[2].substring(1);
    }

    public String productColor (int index){
        List<WebElement> product = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(size));
        String temp = product.get(index).getText();
        String[] tmp = temp.split(":");
        String[] color = tmp[1].split(",");
        return color[0].substring(1);
    }

    // Not working due to the States including multiple words in name such as District of Colorado
//    public String invCity (){
//        String temp = "";
//        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(city).getText();
//        String[] city = temp.split(",");
//        return city[0];
//    }
//
//    public String invState (){
//        String temp = "";
//        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(city).getText();
//        String[] state = temp.split("\\s");
//        return state[1];
//    }
//
//    public String invZip (){
//        String temp = "";
//        temp = wait.until(ExpectedConditions.visibilityOfElementLocated(deliveryAdd)).findElement(city).getText();
//        String[] zip = temp.split("\\s");
//        return zip[2];
//    }

    public String invNum (){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(invoiceAdd)).findElement(number).getText();
    }

    public void continueShopping (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping)).click();
    }

    public void proceed (){
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOut)).click();
    }

    public String totalProdPriceCal (String price, String quantity){
        Double temp;
        temp = Double.parseDouble(price) * Double.parseDouble(quantity);
        String result = String.format("%.2f", temp);
        return String.valueOf(result);
    }

    public String totalPriceCal (String totalPrice[]){
        Double temp = 0.0;
        for (int i = 0; i < 3; i++){
            temp += Double.parseDouble(totalPrice[i]);
        }
        String result = String.format("%.2f", temp);
        return String.valueOf(result);
    }



}
