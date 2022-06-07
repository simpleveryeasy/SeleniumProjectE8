package com.cydeo.review.week05;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.ReviewUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseAdidas extends TestBase {

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
        ReviewUtils.staticWait(3); // PUT one second waiting time
        // First get Cart price then click on place order
        double cartPrice = Double.parseDouble(driver.findElement(By.id("totalp")).getText());
        System.out.println("cartPrice = " + cartPrice);
        // click on Place order : //button[.='Place Order']
        System.out.println("expectedPrice = " + expectedPrice);

        driver.findElement(By.xpath("//button[.='Place Order']")).click();
        ReviewUtils.staticWait(2);

        ReviewUtils.fillForm(driver);

        String confirmationText = driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();

        String IDtext = driver.findElement(By.xpath("//p[@class='lead text-muted ']//br")).getText();
        System.out.println("IDtext = " + IDtext);
        System.out.println("confirmationText = " + confirmationText);
       /*
    Id: 8761753
    Amount: 1150 USD
    Card Number: 3436-094090-48661
    Name: Mrs. Tracey Kuhlman
    Date: 4/5/2022
        */

        String ID = confirmationText.split("\n")[0];
        double actualPrice = Double.parseDouble(confirmationText.split("\n")[1].split(" ")[1]);

        System.out.println(ID);
        System.out.println("actualPrice = " + actualPrice);

        Assert.assertEquals(actualPrice,expectedPrice);
        Assert.assertEquals(cartPrice,expectedPrice);


    }


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


