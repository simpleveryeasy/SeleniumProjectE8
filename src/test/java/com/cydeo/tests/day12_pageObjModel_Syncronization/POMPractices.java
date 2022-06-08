package com.cydeo.tests.day12_pageObjModel_Syncronization;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POMPractices {

    LibraryLoginPage libraryLoginPage;
    Faker faker;

    @BeforeMethod
    public void setupMethod(){
        Driver.getDriver().get("https://library1.cydeo.com");
        libraryLoginPage = new LibraryLoginPage();
    }



    @Test
    public void required_field_error_message_test(){
        //TC #1: Required field error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com


        //3- Do not enter any information
        //4- Click to “Sign in” button


        libraryLoginPage.signInButton.click();

        //5- Verify expected error is displayed:
        //Expected: This field is required.
        Assert.assertTrue(libraryLoginPage.fieldRequiredErrorMessage.isDisplayed());
        //NOTE: FOLLOW POM DESIGN PATTERN
        Driver.closeDriver();

    }

    @Test
    public void invalid_email_format_error_message_test(){

        //TC #2: Invalid email format error message test
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com


        //3- Enter invalid email format
        faker = new Faker();

        libraryLoginPage.inputUserName.sendKeys(faker.bothify("###???"));
        libraryLoginPage.signInButton.click();

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        Assert.assertTrue(libraryLoginPage.enterValidEmailErrorMessage.isDisplayed());

        Driver.closeDriver();
    }


    @Test
    public  void library_negative_logIn_test(){

        //TC #3: Library negative login
        //1- Open a chrome browser
        //2- Go to: https://library1.cydeo.com


        //3- Enter incorrect username or incorrect password
        faker = new Faker();

        libraryLoginPage.inputUserName.sendKeys(faker.bothify("##???@???"));
        libraryLoginPage.inputPassword.sendKeys(faker.numerify("####"));
        libraryLoginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(libraryLoginPage.wrongEmailOrPasswordMessage.isDisplayed());

        Driver.closeDriver();
    }
}
