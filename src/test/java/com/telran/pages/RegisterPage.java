package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageBase{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id ="firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id ="password")
    WebElement password;

    @FindBy(id = "g-recaptcha")
    WebElement recaptcha;

    public RegisterPage fillRegistrationForm(String fName, String lName, String uName, String pwd) {
        type(firstName, fName);
        type(lastName, lName);
        type(userName, uName);
        type(password, pwd);
        return this;
    }
    public RegisterPage clickOnRecaptcha(){
        clickWithAction(recaptcha,0,200);
        return this;
    }
}
