package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName")
    WebElement userName;

    @FindBy(id ="password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;

    @FindBy(id = "newUser")
    WebElement newUserBtn;


    public ProfilePage loginPositive(String username, String passw){
        type(userName,username);
        type(password,passw);
        loginBtn.click();
        return new ProfilePage(driver);
    }
    public LoginPage loginNegative(String username, String passw){
        type(userName,username);
        type(password,passw);
        loginBtn.click();
        return this;
    }
    public RegisterPage clickOnNewUserButton(){
        newUserBtn.click();
        return new RegisterPage(driver);
    }

}
