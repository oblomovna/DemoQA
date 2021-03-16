package com.telran.bookstoretests;

import com.telran.pages.MainPage;
import com.telran.pages.PracticeFormPage;
import com.telran.pages.SidePanelPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PracticeFormPageTest extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        new MainPage(driver).goToFormsPage();
        new SidePanelPage(driver).selectPracticeForm();
    }
    @Test
    public void fillStudentRegistrationForm(){
        new PracticeFormPage(driver)
                .fillFullNameForm("Salvador","Dali","dali2021@gmail.ru","89118762563")
                .selectGender("Male").typeBDay("11 May 1904")
                .addSubject("Maths")
                .selectHobbies("Music")
                .uploadFile("/Users/korypaev/Desktop/Github/4.jpg")
                .typeAddress("Cadaques")
                .addState("Haryana")
                .addCity("Karnal")
                .submit();
        Assert.assertTrue(new PracticeFormPage(driver).getTextAfterFillingOutTheForm().contains("Thanks for submitting"));

    }
}
