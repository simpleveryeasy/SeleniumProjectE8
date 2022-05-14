package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {


        //1. setting up the web driver manager
        //we create our "Browser Driver"
        WebDriverManager.chromedriver().setup();

        //2. create instance of the chrome driver
        //First selenium comment
        WebDriver driver = new ChromeDriver();

        //3. test if driver is working
        driver.get("https://google.com");

        Thread.sleep(3000);

        driver.quit();
    }
}
