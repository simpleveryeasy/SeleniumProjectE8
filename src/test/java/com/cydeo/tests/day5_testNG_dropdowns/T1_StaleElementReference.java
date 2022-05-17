package com.cydeo.tests.day5_testNG_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementReference {

    public static void main(String[] args) {

        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteBtn = driver.findElement(By.xpath("//button[@class = 'added-manually']"));
        System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());

        //5. Click to “Delete” button.
        deleteBtn.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            System.out.println("StaleElementReferenceException is thrown");
            System.out.println("deleteBtn.isDisplayed() = false");
        }
        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}
