package com.telran.bookstoretests;

import com.telran.helpers.JSExecutor;
import com.telran.pages.AlertsPage;
import com.telran.pages.MainPage;

import com.telran.pages.SidePanelPage;
import org.testng.annotations.Test;

public class JSExecutorTest extends TestBase{


    @Test
    public void executorTest(){
        new MainPage(driver).goToElementsPage();
        new SidePanelPage(driver).selectTextBox();
        new JSExecutor(driver).typeNameEmailWithExecutor("Salvador Dali", "dali@gmail.com")
                .refreshBrowserJSE().clickOnSubmit().getTitlePageJSE().getURLPageJSE();
    }
    @Test
    public void checkBoxJSETest(){
        new MainPage(driver).goToFormsPage();
        new SidePanelPage(driver).selectPracticeForm();
        new JSExecutor(driver).checkBoxJSE().alertWithJSE();
        new AlertsPage(driver).acceptAlert();

    }
}
