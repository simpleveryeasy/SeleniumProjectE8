package com.cydeo.tests.day5_testNG_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_SelectDateDropdown {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void test(){
        //3. Select “December 1, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //Select year using : visible text
        yearDropdown.selectByVisibleText("1923");
        //Select month using : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);


        String expectedYear = "1923";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertTrue(actualYear.equals(expectedYear));
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertTrue(actualDay.equals(expectedDay));
    }

}
