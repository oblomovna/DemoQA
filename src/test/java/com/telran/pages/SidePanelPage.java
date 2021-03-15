package com.telran.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SidePanelPage extends PageBase {

    public SidePanelPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[6]/div[1]/div[1]")
    WebElement elementGroup;

    @FindBy(xpath = "//span[.='Browser Windows']")
    WebElement browserWindowsBtn;

    @FindBy(xpath = "//span[.='Alerts']")
    WebElement alertsBtn;


    public BookStorePage goToLogin() {
       elementGroup.click();
        return new BookStorePage(driver);
    }
    public BrowserWindowPage selectBrowserWindows(){
        clickWithAction(browserWindowsBtn,0,300);
        return new BrowserWindowPage(driver);
    }
    public AlertsPage selectAlerts(){
        clickWithAction(alertsBtn,0,300);
        return new AlertsPage(driver);
    }
}
