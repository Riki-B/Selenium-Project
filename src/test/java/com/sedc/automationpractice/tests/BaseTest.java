package com.sedc.automationpractice.tests;

import com.sedc.automationpractice.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class BaseTest {
/*    -Registracija na nov korisnik
    -Dodavanje nekolku produkti vo koshnicka
    -Brishenje na 1 produkt od koshnicka
    -Check out na poracka (Check out> Shipping Adress> Place order) itn.*/

    WebDriver driver;
    WebDriverWait wait;
    int timeout = 15;
    public static JavascriptExecutor js;
    HomePage homePage;
    SignInPage signInPage;
    CreateUserPage createUserPage;
    MyAccountPage myAccountPage;
    CategoriesPage categoriesPage;
    ViewProductPage viewProductPage;
    CheckOutSummaryPage checkOutSummaryPage;
    SoftAssert softAssert;
    QuickViewPage quickViewPage;
    CheckOutAddressPage checkOutAddressPage;
    CheckOutShippingPage checkOutShippingPage;
    CheckOutPaymentPage checkOutPaymentPage;
    String createdEmail = "rikitest+test1@protonmail.com";
    String pass = "12345";

    @Parameters({"browserName"})
    @BeforeMethod
    public void setup(@Optional("Chrome") String browserN) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        String browserName = browserN;
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", "src/test/resources/drivers/operadriver.exe");
            driver = new OperaDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeout);
        js = (JavascriptExecutor) driver;
        homePage = new HomePage(driver, wait);
        signInPage = new SignInPage(driver, wait);
        createUserPage = new CreateUserPage(driver, wait);
        myAccountPage = new MyAccountPage(driver, wait);
        categoriesPage = new CategoriesPage(driver, wait);
        viewProductPage = new ViewProductPage(driver, wait);
        checkOutSummaryPage = new CheckOutSummaryPage(driver, wait);
        softAssert = new SoftAssert();
        quickViewPage = new QuickViewPage(driver, wait);
        checkOutAddressPage = new CheckOutAddressPage(driver, wait);
        checkOutShippingPage = new CheckOutShippingPage(driver, wait);
        checkOutPaymentPage = new CheckOutPaymentPage(driver, wait);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    public static void scrollDown(int pixel) {
        js.executeScript("window.scrollBy(0, " + pixel + ")");
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
