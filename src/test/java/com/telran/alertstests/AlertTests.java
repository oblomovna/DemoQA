package com.telran.alertstests;

import com.telran.bookstoretests.TestBase;
import com.telran.pages.AlertsPage;
import com.telran.pages.MainPage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        new MainPage(driver).goToAlertPage();
        new SidePanelPage(driver).selectAlerts();
    }
    @Test
    public void firstAlertButtonTest(){
        new AlertsPage(driver).clickAlertButton1();
    }
    @Test
    public void alertWaitTest(){
        new AlertsPage(driver).clickAlertButton2AndWait();
    }

    @Test
    public void cancelAlertTest(){
        new AlertsPage(driver).clickAlertButton3().clickOnCancelButton("Cancel");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("Cancel"));
    }
    @Test
    public void okAlertTest(){
        new AlertsPage(driver).clickAlertButton3().clickOnCancelButton("ok");
        Assert.assertTrue(new AlertsPage(driver).getConfirmResult().contains("ok"));
    }
    @Test
    public void alertSendTextTest(){
        new AlertsPage(driver).clickAlertButton4().sendTextToAlert("Hello");
        Assert.assertTrue(new AlertsPage(driver).getConfirmLastResult().contains("Hello"));
    }
}
