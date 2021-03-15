package com.telran.bookstoretests;

import com.telran.pages.BookStorePage;
import com.telran.pages.LoginPage;
import com.telran.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookToCollectionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        new MainPage(driver).goToBookStorePage();
        new BookStorePage(driver).goToLoginPage();
        new LoginPage(driver).loginPositive("Musashi","Musa98765?!");

    }

    @Test
    public void addBookToCollectionTest(){
        String text ="Git";
        new BookStorePage(driver).typeInSearchFieldInput(text)
                .addBookToCollection().clickOnProfileBtn();

        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));

    }
}
