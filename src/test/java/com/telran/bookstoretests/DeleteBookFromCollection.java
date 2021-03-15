package com.telran.bookstoretests;

import com.telran.pages.BookStorePage;
import com.telran.pages.LoginPage;
import com.telran.pages.MainPage;
import com.telran.pages.ProfilePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBookFromCollection extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        new MainPage(driver).goToBookStorePage();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).loginPositive("Musashi", "Musa98765?!");
        new BookStorePage(driver).addBookToCollection().clickOnProfileBtn();

    }

    @Test
    public void deleteBookFromCollectionTest() {
        new ProfilePage(driver).clickOnDeleteBookBtn();
       // driver.switchTo().alert().accept();
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));

    }
}
