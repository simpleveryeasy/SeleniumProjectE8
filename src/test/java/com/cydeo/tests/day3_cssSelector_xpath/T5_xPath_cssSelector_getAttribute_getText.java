package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_xPath_cssSelector_getAttribute_getText {

    public static void main(String[] args) {

        //TC #5: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement loginBox = driver.findElement(By.xpath("//input[@class = 'login-inp']"));
        loginBox.sendKeys("Incorrect Username");

        //4- Click to `Reset password` button
        WebElement resetButton = driver.findElement(By.cssSelector("button[class='login-btn']"));
        resetButton.click();

        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found
        WebElement errorLabel = driver.findElement(By.cssSelector("div[class = 'errortext']"));
        String expectedErrorLabel = "Login or E-mail not found";
        String actualErrorLabel = errorLabel.getText();

        if (actualErrorLabel.equals(expectedErrorLabel)){
            System.out.println("Error label verification PASSED!");
        }else {
            System.out.println("Error label verification FAILED!!!");
        }
        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
