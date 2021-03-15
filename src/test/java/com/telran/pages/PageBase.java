package com.telran.pages;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.io.FileUtils;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class PageBase {
    protected WebDriver driver;

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void pause(int millis){
        try{
            Thread.sleep(millis);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void takeScreenshotField(WebElement element) throws IOException {
        element.isSelected();

        File screenshotField = element.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenshotField, new File(System.getProperty("user.dir")+"/screenshots/"
                + new Random().nextInt() + ".png"));

    }
    public void takeScreenshot(String pathToFile){
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File(pathToFile);
        try {

            Files.copy(tmp, screenshot);
        }catch (IOException e){
            e.fillInStackTrace();
        }
    }
    public void clickWithAction(WebElement element, int x, int y){
       // Actions actions = new Actions(driver);
       // actions.moveToElement(driver.findElement(By.cssSelector(""))).click().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        element.click();
    }
}
