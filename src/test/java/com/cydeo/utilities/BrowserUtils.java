package com.cydeo.utilities;

   //In this class only general utility methods that are not related to some specific page.

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e){

        }
    }

    //This method switchTo expectedUrl and Assert actualTitle contains expectedInTitle
    public static void switchWindowAndVerify(WebDriver driver, String expectedUrl, String expectedInTitle){
        Set<String> allWindowsHandles = driver.getWindowHandles();
        for (String each : allWindowsHandles){
            driver.switchTo().window(each);

            System.out.println("Current URL: " + driver.getCurrentUrl());

            if (driver.getCurrentUrl().contains(expectedUrl)){
                break;
            }
        }
        //Assert title contains expectedInTitle
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }


    //This method accepts String expectedTitle and Asserts if it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){

        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }








}
