package com.telran.alertstests;

import com.telran.bookstoretests.TestBase;
import com.telran.pages.BrowserWindowPage;
import com.telran.pages.MainPage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        new MainPage(driver).goToAlertPage();
        new SidePanelPage(driver).selectBrowserWindows();
    }
    @Test
    public void newTabTest(){
        new BrowserWindowPage(driver).clickOnNewTabButton();
        Assert.assertTrue(new BrowserWindowPage(driver).getTextFromNewTab().contains("sample"));
    }
    @Test
    public void newWindowTest(){
        new BrowserWindowPage(driver).clickOnNewWindowButton();
        Assert.assertTrue(new BrowserWindowPage(driver).getTextFromNewWindowBtn().contains("sample"));
    }
    @Test
    public void newWindowMessageTest(){
        new BrowserWindowPage(driver).clickOnNewWindowMessageButton();
        Assert.assertTrue(new BrowserWindowPage(driver).isTextFromNewWindowMessageDisplayed());

    }
}
