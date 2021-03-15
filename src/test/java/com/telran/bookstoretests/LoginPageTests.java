package com.telran.bookstoretests;
import com.telran.pages.BookStorePage;
import com.telran.pages.LoginPage;

import com.telran.pages.MainPage;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase{

    @Test
    public void loginTest(){
        new MainPage(driver).goToBookStorePage();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).loginPositive("Musashi","Musa98765?!")
                .verifyUserName("Musashi")
                .logout();
    }

}
