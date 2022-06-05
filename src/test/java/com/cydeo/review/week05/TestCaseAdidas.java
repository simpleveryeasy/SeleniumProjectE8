package com.cydeo.review.week05;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseAdidas {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void Test(){
        double expectedPrice = 0;
        driver.get("https://www.demoblaze.com/index.html");
        // ConfigurationReader.getProperty("category1") ----> returns Laptops
        expectedPrice += ReviewUtils.addProduct(driver, ConfigurationReader.getProperty("category1"),"Sony vaio i5");
        ReviewUtils.getLink(driver,"Home");
        expectedPrice += ReviewUtils.addProduct(driver,ConfigurationReader.getProperty("category2"),"Samsung galaxy s6");
        // go to Cart
        ReviewUtils.getLink(driver,"Cart");

        // First get Cart price then click on place order
        double cartPrice = Double.parseDouble(driver.findElement(By.id("totalp")).getText());
        System.out.println("cartPrice = " + cartPrice);
        // click on Place order : //button[.='Place Order']
        System.out.println("expectedPrice = " + expectedPrice);

        driver.findElement(By.xpath("//button[.='Place Order']")).click();

    }

    //Smartbear software order placing
    //1. Open browser
    //2. Go to website:
    //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    //3. Enter username: “Tester”
    //4. Enter password: “test”
    //5. Click on Login button
    //6. Click on Order
    //7. Select familyAlbum from product, set quantity to 2
    //8. Click to “Calculate” button
    //9. Fill address Info with JavaFaker
    //• Generate: name, street, city, state, zip code
    //10. Click on “visa” radio button
    //11. Generate card number using JavaFaker
    //12. Click on “Process”
    //13. Verify success message “New order has been successfully added.”
    //
    //    You have to implement the following Web automated checks over our DEMO ONLINE
    //    SHOP: https://www.demoblaze.com/index.html
    //    • Customer navigation through product categories: Phones, Laptops and Monitors
    //    • Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.  --- Create a custom method for adding products
    //    • Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". Accept pop up confirmation.
    //    • Click on "Place order".
    //    • Fill in all web form fields. ----USE JavaFaker---create a fillForm() custom method
    //    • Click on "Purchase"
    //    • Capture and log purchase Id and Amount.
    //    • Assert purchase amount equals expected.
    //    • Click on "Ok"

}
