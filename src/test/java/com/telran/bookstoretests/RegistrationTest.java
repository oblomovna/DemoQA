package com.telran.bookstoretests;

import com.telran.pages.BookStorePage;
import com.telran.pages.LoginPage;
import com.telran.pages.MainPage;
import com.telran.pages.RegisterPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToBookStorePage();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).clickOnNewUserButton();
    }
    @Test
    public void registrationTest(){
        int i =(int) (System.currentTimeMillis()/1000%3600);
        String fName= "Tuluse" + i;
        String lName = "Lautrec" + i;
        String uName = "lautrec" + i;
        String pwd = "Lautrec-2021!" + i;

        new RegisterPage(driver).fillRegistrationForm(fName,lName,uName,pwd).clickOnRecaptcha();

    }
}
