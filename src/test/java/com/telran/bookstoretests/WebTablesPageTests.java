package com.telran.bookstoretests;

import com.telran.helpers.JSExecutor;
import com.telran.pages.MainPage;
import com.telran.pages.SidePanelPage;
import org.testng.annotations.Test;

public class WebTablesPageTests extends TestBase{

    @Test
    public void checkNameByAge(){
        new MainPage(driver).goToElementsPage();
        new SidePanelPage(driver).selectWebTables();
        new JSExecutor(driver).typeAgeToSearchPanel(29).showNameByAge(29);
    }
}
