package com.cydeo.tests.day10_uploads_actions_jsexecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_RegistrationForm {

    @Test
    public void registrationform_test(){

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registrationform.url"));

        Faker faker =new Faker();

        //3. Enter first name
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());

        //4. Enter last name
        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        //inputUserName.sendKeys(faker.name().username().replaceAll(".", ""));
        String user = faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);

        //6. Enter email address
        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@email.com");

        //7. Enter password
        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.bothify("##???###"));

        //8. Enter phone number
        WebElement inputPhoneNumber = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhoneNumber.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons //
        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        inputGender.click();

        //10. Enter date of birth
        WebElement inputBirthDate = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        inputBirthDate.sendKeys(faker.number().numberBetween(1, 12)+"/"+faker.number().numberBetween(1, 30)+"/"+faker.numerify("197#"));

        //11. Select Department/Office
        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1, 9));

        //12. Select Job Title
        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1 ,8));

        //13. Select programming language from checkboxes
        WebElement checkboxProgrammingLanguage = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        checkboxProgrammingLanguage.click();

        //14. Click to sign up button
        WebElement buttonSignup = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        buttonSignup.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        String successMessage = "You've successfully completed registration!";
        WebElement alertHeading = Driver.getDriver().findElement(By.tagName("p"));
        System.out.println("alertHeading.getText() = " + alertHeading.getText());

        Assert.assertEquals(alertHeading.getText(), successMessage);

    }
}
