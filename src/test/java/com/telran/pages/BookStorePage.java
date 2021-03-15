package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookStorePage extends PageBase{

    public BookStorePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "login")
    WebElement loginBSP;

    @FindBy(id = "searchBox")
    WebElement searchInput;

    @FindBy(xpath = "//span[@class='mr-2']/a")
    //   //span[@id='see-book-Git Pocket Guide']
    WebElement nameOfBook;

    @FindBy(css = ".text-right.fullButton")
    WebElement addToCollectionBtn;

    @FindBy(css = ".show #item-3")
    WebElement profileBtn;


    public LoginPage goToLoginPage(){
        loginBSP.click();
        return new LoginPage(driver);
    }
    public BookStorePage typeInSearchFieldInput(String text){
        type(searchInput,text);
        return this;
    }
    public String takeNameOfBook(){
        pause(500);
        return driver.findElement(By.xpath("//span[@id='see-book-Git Pocket Guide']")).getText();
    }
    public String verifyEmptyField(){
        pause(500);
        return driver.findElement(By.cssSelector(".rt-tr-group:nth-child(1) .rt-td:nth-child(2)")).getText();
    }

    public BookStorePage addBookToCollection(){
        nameOfBook.click();
        clickWithAction(addToCollectionBtn,0,300);
        pause(500);
        driver.switchTo().alert().accept();
        return this;

    }
    public BookStorePage clickOnProfileBtn(){
        clickWithAction(profileBtn,0,500);
        return this;
    }
}
