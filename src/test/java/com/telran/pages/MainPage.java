package com.telran.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase{

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='category-cards']/div[.='Book Store Application']")
    WebElement bookStore;

    @FindBy(xpath = "//div/h5[.='Alerts, Frame & Windows']")
    WebElement alertFrameAndWindowsBtn;

    public BookStorePage goToBookStorePage(){
        clickWithAction(bookStore,0,500);
       // bookStore.click();
        return new BookStorePage(driver);
    }
    public SidePanelPage goToAlertPage(){
        clickWithAction(alertFrameAndWindowsBtn,0,300);

        return new SidePanelPage(driver);
    }
}

