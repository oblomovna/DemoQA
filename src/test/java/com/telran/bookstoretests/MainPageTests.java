package com.telran.bookstoretests;

import com.telran.pages.MainPage;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase{

   @Test
    public void goToLoginPageFromMainPage(){
       new MainPage(driver).goToBookStorePage();
   }

}
