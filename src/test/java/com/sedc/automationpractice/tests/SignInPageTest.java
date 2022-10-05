package com.sedc.automationpractice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SignInPageTest extends BaseTest {

    @Test(description = "Check if there is a user with this email and if an error message pops up")
    public void validateExistingUserCreation() {
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createdEmail);
        signInPage.createButton();
        Assert.assertTrue(signInPage.checkErrorMessage());
    }

    @Test(description = "Check if using a new address will bring the sign up screen")
    public void checkSignUp() {
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.createAddEmail(createUserPage.randomEmail());
        signInPage.createButton();
        Assert.assertTrue(signInPage.checkCreatePage());
    }

    @Test(description = "Validate sign in with incorrect login credentials")
    public void validateSignInInvalidCred() {
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.signInEmail(createdEmail);
        signInPage.signInPass("asdet");
        signInPage.signIn();
        Assert.assertTrue(signInPage.checkSignInErrorMessage());
    }

    @Test(description = "Validate sign in with correct login credentials")
    public void validateSignInCorrectCred() {
        homePage.navigateToPage();
        homePage.navigateToSignIn();
        signInPage.signInEmail(createdEmail);
        signInPage.signInPass(pass);
        signInPage.signIn();
        Assert.assertTrue(signInPage.checkSingInPage());
    }

}
