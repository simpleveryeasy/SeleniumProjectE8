package com.cydeo.tests.day6_alerts_iFrames_Windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_Windows_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //TC #5: Window Handle practice
        //1. Create a new class called: T5_WindowsPractice
        //2. Create new test and make set ups
        //3. Go to : https://practice.cydeo.com/windows
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("https://practice.cydeo.com/windows");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void windows_test(){
        //storing the main page window handle as a string
        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);//CDwindow-11B2A549DB357CBA2EABBB16EC85AA3B

        //4. Assert: Title is “Windows”
        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);

        //5. Click to: “Click Here” link
        System.out.println("Title before click: " + actualTitle); //Title before click: Windows

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        System.out.println("Title after click: " + actualTitle); //Title after click: Windows

        //6. Switch to new Window.
        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);
            System.out.println("Current title while switching windows: " + driver.getTitle());
        }
        //7. Assert: Title is “New Window”
        String expectedTitleAfterClick = "New Window";
        actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitleAfterClick);
        System.out.println("Title after click: " + actualTitle); //Title after click: New Window

        String secondWindowHandle = driver.getWindowHandle();
        System.out.println("Second window handle: " + secondWindowHandle); //CDwindow-0076F8DC8AACA2E4F47FAD9A4149994F

        driver.switchTo().window(mainHandle);
        System.out.println("mainHandle = " + mainHandle);//CDwindow-11B2A549DB357CBA2EABBB16EC85AA3B
    }
}
