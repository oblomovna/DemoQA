package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class BrowserWindowPage extends PageBase{

    public BrowserWindowPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "tabButton")
    WebElement newTabBtn;

    @FindBy(id = "windowButton")
    WebElement newWindowBtn;

    @FindBy(id = "messageWindowButton")
    WebElement newWindowMessageBtn;


    public BrowserWindowPage clickOnNewTabButton(){
        newTabBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    public String getTextFromNewTab(){
        return driver.findElement(By.id("sampleHeading")).getText();
    }
    public BrowserWindowPage clickOnNewWindowButton(){
        newWindowBtn.click();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    public String getTextFromNewWindowBtn(){
        return driver.findElement(By.id("sampleHeading")).getText();
    }
    public BrowserWindowPage clickOnNewWindowMessageButton(){
        //newWindowMessageBtn.click();
        clickWithAction(newWindowMessageBtn,0,50);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return this;
    }
    public boolean isTextFromNewWindowMessageDisplayed() {
        return driver.findElement(By
                .xpath("//body(.,'Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.')")).isDisplayed();
    }
}
