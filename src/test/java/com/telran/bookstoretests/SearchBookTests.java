package com.telran.bookstoretests;

import com.telran.pages.BookStorePage;
import com.telran.pages.MainPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchBookTests extends TestBase{

    @Test
    public void searchBookPositiveTest() throws IOException {
        new MainPage(driver).goToBookStorePage();
        String text = "Git";
        new BookStorePage(driver).typeInSearchFieldInput(text).takeNameOfBook();
        Assert.assertTrue(new BookStorePage(driver).takeNameOfBook().contains(text));

        new BookStorePage(driver).takeScreenshotField(driver.findElement(By.xpath("//span[@class='mr-2']/a")));

    }
    @Test
    public void verifyEmptyFieldTest(){
        new MainPage(driver).goToBookStorePage();
        new BookStorePage(driver).typeInSearchFieldInput("  ").verifyEmptyField();
        Assert.assertTrue(new BookStorePage(driver).verifyEmptyField().contains(""));
    }
}
