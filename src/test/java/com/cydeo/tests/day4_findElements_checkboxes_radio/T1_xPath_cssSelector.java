package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xPath_cssSelector {

    public static void main(String[] args) {

        //XPATH and CSS Selector PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class= 'nav-link']"));
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));
        WebElement homeLink_ex4 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink_ex5 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink_ex6 = driver.findElement(By.cssSelector("a.nav-link"));

        //b. “Forgot password” header
        WebElement forgotPasswordHeader_ex1 = driver.findElement(By.cssSelector("div.example > h2"));
        WebElement forgotPasswordHeader_ex2 = driver.findElement(By.xpath("//h2"));
        WebElement forgotPasswordHeader_ex3 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        WebElement forgotPasswordHeader_ex4 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));

        //c. “E-mail” text
        WebElement emailLabel_ex1 = driver.findElement(By.xpath("//label[@for = 'email']"));
        WebElement emailLabel_ex2 = driver.findElement(By.xpath("//label[.='E-mail']"));

        //d. E-mail input box
        WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement inputBox_ex3 = driver.findElement(By.xpath("//input[contains(@pattern, 'a-z')]"));

        //e. “Retrieve password” button
        WebElement retrievePasswordButton_ex1 = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        WebElement retrievePasswordButton_ex2 = driver.findElement(By.xpath("//i[contains(@class,'ico')]"));
        WebElement retrievePasswordButton_ex3 = driver.findElement(By.cssSelector("button > i"));
        WebElement retrievePasswordButton_ex4 = driver.findElement(By.cssSelector("button.radius"));
        WebElement retrievePasswordButton_ex5 = driver.findElement(By.cssSelector("button#form_submit"));

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText_ex1 = driver.findElement(By.xpath("//div[contains(@style,'text-al')]"));
        WebElement poweredByCydeoText_ex2 = driver.findElement(By.xpath("//div[@style = 'text-align: center;']"));
        WebElement poweredByCydeoText_ex3 = driver.findElement(By.cssSelector("div[style = 'text-align: center;']"));


        //4. Verify all web elements are displayed.

        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("forgotPasswordHeader_ex1.isDisplayed() = " + forgotPasswordHeader_ex1.isDisplayed());
        System.out.println("emailLabel_ex1.isDisplayed() = " + emailLabel_ex1.isDisplayed());
        System.out.println("inputBox_ex1.isDisplayed() = " + inputBox_ex1.isDisplayed());
        System.out.println("retrievePasswordButton_ex1.isDisplayed() = " + retrievePasswordButton_ex1.isDisplayed());
        System.out.println("poweredByCydeoText_ex1.isDisplayed() = " + poweredByCydeoText_ex1.isDisplayed());

        System.out.println("________________________________");
        String expectedHomeLink = homeLink_ex1.getText();
        System.out.println(expectedHomeLink);
        expectedHomeLink = homeLink_ex2.getText();
        System.out.println(expectedHomeLink);
        expectedHomeLink = homeLink_ex3.getText();
        System.out.println(expectedHomeLink);
        expectedHomeLink = homeLink_ex4.getText();
        System.out.println(expectedHomeLink);
        expectedHomeLink = homeLink_ex5.getText();
        System.out.println(expectedHomeLink);
        expectedHomeLink = homeLink_ex6.getText();
        System.out.println(expectedHomeLink);

        System.out.println("________________________________");
        String expectedForgotPasswordHeader = forgotPasswordHeader_ex1.getText();
        System.out.println(expectedForgotPasswordHeader);
        expectedForgotPasswordHeader = forgotPasswordHeader_ex2.getText();
        System.out.println(expectedForgotPasswordHeader);
        expectedForgotPasswordHeader = forgotPasswordHeader_ex3.getText();
        System.out.println(expectedForgotPasswordHeader);
        expectedForgotPasswordHeader = forgotPasswordHeader_ex4.getText();
        System.out.println(expectedForgotPasswordHeader);

        System.out.println("________________________________");
        String expectedEmailLabel = emailLabel_ex1.getText();
        System.out.println(expectedEmailLabel);
        expectedEmailLabel = emailLabel_ex2.getText();
        System.out.println(expectedEmailLabel);

        System.out.println("________________________________");
       String expectedInputBox = inputBox_ex1.getText();
        System.out.println(expectedInputBox);
       expectedInputBox = inputBox_ex2.getText();
        System.out.println(expectedInputBox);
       expectedInputBox = inputBox_ex3.getText();
        System.out.println(expectedInputBox);

        System.out.println("________________________________");
       String expectedRetrivePassworButton = retrievePasswordButton_ex1.getText();
        System.out.println(expectedRetrivePassworButton);
       expectedRetrivePassworButton =retrievePasswordButton_ex2.getText();
        System.out.println(expectedRetrivePassworButton);
       expectedRetrivePassworButton = retrievePasswordButton_ex3.getText();
        System.out.println(expectedRetrivePassworButton);
       expectedRetrivePassworButton = retrievePasswordButton_ex4.getText();
        System.out.println(expectedRetrivePassworButton);
       expectedRetrivePassworButton = retrievePasswordButton_ex5.getText();
        System.out.println(expectedRetrivePassworButton);

        System.out.println("________________________________");
        String expectedPoweredByCydeoText = poweredByCydeoText_ex1.getText();
        System.out.println(expectedPoweredByCydeoText);
        expectedPoweredByCydeoText = poweredByCydeoText_ex2.getText();
        System.out.println(expectedPoweredByCydeoText);
        expectedPoweredByCydeoText = poweredByCydeoText_ex3.getText();
        System.out.println(expectedPoweredByCydeoText);


        //First solve the task with using cssSelector only. Try to create 2 different
        //cssSelector if possible
        //Then solve the task using XPATH only. Try to create 2 different
        //XPATH locator if possible
    }
}
