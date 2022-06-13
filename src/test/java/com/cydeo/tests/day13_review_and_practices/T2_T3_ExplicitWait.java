package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_T3_ExplicitWait {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod(){

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");
        dynamicControlsPage = new DynamicControlsPage();
    }

    @Test
    public void remove_button_test(){

        //TC #2: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Remove” button
        dynamicControlsPage.removeButton.click();

        //4- Wait until “loading bar disappears”

        //WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);


        //5- Verify:
        //a. Checkbox is not displayed
        try {
            Assert.assertFalse(dynamicControlsPage.checkbox.isDisplayed());
        }catch(NoSuchElementException n){
            Assert.assertTrue(true);
        }

        //b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());
        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's gone!");

        //NOTE: FOLLOW POM
        Driver.closeDriver();
    }

    @Test
    public void enable_button_test(){

        //TC #3: Explicit wait practice
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        //3- Click to “Enable” button
        dynamicControlsPage.enableButton.click();

        //4- Wait until “loading bar disappears”
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        //b. “It’s enabled!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());
        Assert.assertEquals(dynamicControlsPage.message.getText(), "It's enabled!");

        Driver.closeDriver();


    }

}
