package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends PageBase{

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstName")
    WebElement firstName;

    @FindBy(id = "lastName")
    WebElement lastName;

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userNumber")
    WebElement mobileNumber;

    public PracticeFormPage fillFullNameForm(String fName,String lName, String email, String number){
        type(firstName,fName);
        type(lastName,lName);
        type(userEmail,email);
        type(mobileNumber,number);
        return this;
    }
    @FindBy(xpath = "//label[@for='gender-radio-1']")
    WebElement maleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-2']")
    WebElement femaleBtn;

    @FindBy(xpath = "//label[@for='gender-radio-3']")
    WebElement otherBtn;

    public PracticeFormPage selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            maleBtn.click();
        } else if (gender.equalsIgnoreCase("female")) {
            femaleBtn.click();
        } else {
            otherBtn.click();
        }
        return this;
    }
    @FindBy(id = "dateOfBirthInput")
    WebElement dateOfBirth;

    public PracticeFormPage typeBDay(String bDay){
        dateOfBirth.click();
        String os = System.getProperty("os.name");
        System.out.println(os);
        if(os.startsWith("Mac")){
            dateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }else{
            dateOfBirth.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        }
        dateOfBirth.sendKeys(bDay);
        dateOfBirth.sendKeys(Keys.ENTER);
        return this;
    }
    @FindBy(id = "subjectsInput")
    WebElement subjectInput;

    @FindBy(id = "react-select-2-option-0")
    WebElement selectInput;

    public PracticeFormPage addSubject(String subject){
        type(subjectInput,subject);
        selectInput.click();
        return this;
    }
    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    WebElement hobbiesSports;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-2']")
    WebElement hobbiesReading;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-3']")
    WebElement hobbiesMusic;

    public PracticeFormPage selectHobbies(String hobbies) {
        if (hobbies.equalsIgnoreCase("Sports")){
            hobbiesSports.click();
        }else if (hobbies.equalsIgnoreCase("Reading")){
            hobbiesReading.click();
        }else{
            hobbiesMusic.click();
        }
        return this;
    }
    @FindBy(xpath = "//input[@id='uploadPicture']")
    WebElement chooseFile;

    public PracticeFormPage uploadFile(String path){
        chooseFile.sendKeys(path);
        pause(3000);
        return this;
    }
    @FindBy(id = "currentAddress")
    WebElement address;

    public PracticeFormPage typeAddress(String add){
        typeWithAction(address,0,300,add);
        return this;
    }
    @FindBy(id = "submit")
    WebElement submitBtn;

    public PracticeFormPage submit(){
        clickWithAction(submitBtn,0,200);
        return this;
    }
    @FindBy(xpath = "//div[contains(text(),'Select State')]")
    WebElement selectStateBtn;

    @FindBy(id = "react-select-3-option-2")
    WebElement selectedState;

    public PracticeFormPage addState(String state){
        if(state.equalsIgnoreCase("Haryana"))
            clickWithAction(selectStateBtn,0,200);
        selectedState.click();
        return this;
    }
    @FindBy(xpath = "//div[contains(text(),'Select City')]")
    WebElement selectCityBtn;

    @FindBy(id = "react-select-4-option-0")
    WebElement selectedCity;

    public PracticeFormPage addCity(String city){
        if(city.equalsIgnoreCase("Karnal"))
        selectCityBtn.click();
        selectedCity.click();
        return this;

    }

    public String getTextAfterFillingOutTheForm(){
        return driver.findElement(By.className("modal-header")).getText();
    }
}
