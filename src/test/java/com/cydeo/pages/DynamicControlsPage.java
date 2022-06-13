package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    public DynamicControlsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "form#checkbox-example > button") // or (xpath = //button[.='Remove'])
    public WebElement removeButton;

    @FindBy(css = "div#loading")
    public WebElement loadingBar;

    //@FindBy(css = "input[label = 'blah']")
    @FindBy(css = "input[type='checkbox']")
    public WebElement checkbox;

    @FindBy(css = "p#message")
    public WebElement message;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(css = "input[type= 'text']")
    public WebElement inputBox;
}
