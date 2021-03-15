package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProfilePage extends PageBase{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "userName-value")
    WebElement userValue;

    @FindBy(id = "submit")
    WebElement logoutBtn;

    @FindBy(xpath = "//*[@id='delete-record-undefined']")
    List<WebElement> bookList;

    @FindBy(id = "#closeSmallModal-ok")
    WebElement okBtn;



    public ProfilePage verifyUserName(String uName) {
        if (userValue.getText().equalsIgnoreCase(uName)){
            System.out.println("Correct user name: " + userValue.getText());
    }else{
            System.out.println("Incorrect user name: " + userValue.getText());
        }
        return this;
    }
    public LoginPage logout(){
        System.out.println("Let's out from profile");
        logoutBtn.click();
        return new LoginPage(driver);
    }
    public ProfilePage clickOnDeleteBookBtn(){
        bookList.get(0).click();
        pause(2000);
        okBtn.click();
        pause(2000);
        driver.switchTo().alert().accept();
        return this;

    }
}
