package com.cydeo.tests.day7_webtables_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_Login {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    //Login scenario
    @Test
    public void crm_login_test1(){
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3. Enter valid username
        WebElement inputUserName = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUserName.sendKeys("helpdesk1@cybertekschool.com");

        //4. Enter valid password
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");

        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");

        // helpdesk1@cybertekschool.com ---> UserUser
    }


    @Test
    public void crm_login_test2() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling utility method to login helpdesk1
        CRM_Utilities.crm_login(driver);

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");
    }

    @Test
    public void crm_login_test3() {
        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //Calling utility method to login helpdesk1
        CRM_Utilities.crm_login(driver, "helpdesk2@cybertekschool.com", "UserUser");

        //6. Verify title is as expected:
        //Expected: Portal
        BrowserUtils.verifyTitle(driver, "Portal");
    }

}
