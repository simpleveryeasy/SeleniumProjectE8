package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicsNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1-Set up the browser driver
        WebDriverManager.chromedriver().setup();

        //2-Create instance of the Selenium WebDriver
        WebDriver driver = new ChromeDriver();

        //-maximize the browser page
        driver.manage().window().maximize();

        //driver.manage().window().fullscreen(); this comment also does the same thing for mac

        //3-Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        //-get the title of the page
        String currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //-get the current URL
        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //4-stop code execution for 3 seconds
        Thread.sleep(3000);

        //5-use selenium to navigate back
        driver.navigate().back();

        //6-stop code execution for 3 seconds
        Thread.sleep(3000);

        //7-use selenium to navigate forward
        driver.navigate().forward();

        //8-stop code execution for 3 seconds
        Thread.sleep(3000);

        //9-use selenium to refresh
        driver.navigate().refresh();

        //-stop code execution for 3 seconds
        Thread.sleep(3000);

        //-use navigate().to():
        driver.navigate().to("https://www.google.com");

        //-get the title of the page
        currentTitle = driver.getTitle();
        System.out.println("currentTitle = " + currentTitle);

        //-get the current URL
        currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        //-stop code execution for 3 seconds
        Thread.sleep(3000);

        //-this will close currently open window selenium focused on last
        driver.close();

        //-stop code execution for 3 seconds
        Thread.sleep(3000);

        //-this will close all windows, kills the session, nothing goes after this you get NoSuchSessionException
        driver.quit();



    }
}
