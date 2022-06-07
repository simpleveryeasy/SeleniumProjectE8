package com.cydeo.tests.day10_uploads_actions_jsexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UploadPractice {


    @Test
    public void upload_test(){

        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "/Users/suleyman/Desktop/HTML Class/OlafVlog/olafTheDog.jpeg";

        //3. Upload the file.
        WebElement uploadLink = Driver.getDriver().findElement(By.id("file-upload"));
        BrowserUtils.sleep(3);
        uploadLink.sendKeys(path);

        //4. Assert:
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));
        uploadButton.click();

        WebElement fileUploadHeader = Driver.getDriver().findElement(By.tagName("h3"));
        WebElement uploadedFileName = Driver.getDriver().findElement(By.xpath("//div[@id='uploaded-files']"));
        String fileName = "olafTheDog.jpeg";

        Assert.assertTrue(fileUploadHeader.isDisplayed());

        Assert.assertEquals(uploadedFileName.getText(), fileName);

        //-File uploaded text is displayed on the page
    }
}
