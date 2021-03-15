package com.telran.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsPage extends PageBase{
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "alertButton")
    WebElement alertBtn1;

    @FindBy(id = "timerAlertButton")
    WebElement alertBtn2;

    @FindBy(id = "confirmButton")
    WebElement confirmBtn3;

    @FindBy(xpath = "(//*[@class='col']//button)[last()]")
    WebElement alertBtn4;

    public AlertsPage clickAlertButton1(){
        alertBtn1.click();
        pause(1000);
        driver.switchTo().alert().accept();
        return this;
    }


    public AlertsPage clickAlertButton2AndWait(){
        alertBtn2.click();
        WebDriverWait wait = new WebDriverWait(driver,10);
        Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());
        myAlert.accept();
        return this;
    }
    public AlertsPage clickAlertButton3(){
        confirmBtn3.click();
        pause(1000);
        return this;
    }
    public AlertsPage clickOnCancelButton(String text){
        if(text!=null && text.equalsIgnoreCase("cancel")){
            driver.switchTo().alert().dismiss();
        }else if (text!=null && text.equalsIgnoreCase("ok")){
            driver.switchTo().alert().accept();
        }
        return this;
    }
    public String getConfirmResult(){
        return driver.findElement(By.id("confirmResult")).getText();
    }
    public AlertsPage clickAlertButton4(){
        alertBtn4.click();
        pause(1000);
        return this;
    }
    public AlertsPage sendTextToAlert(String text){
        if(text!=null)
            driver.switchTo().alert().sendKeys(text);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        return this;
    }
    public String getConfirmLastResult(){
        return driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
    }
}
