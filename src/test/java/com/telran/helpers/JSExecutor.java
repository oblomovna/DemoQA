package com.telran.helpers;

import com.telran.pages.PageBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JSExecutor extends PageBase {

    JavascriptExecutor js;

    public JSExecutor(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
    }
    @FindBy(id = "userName")
    WebElement uName;

    @FindBy(id = "userEmail")
    WebElement uEmail;

    @FindBy(id = "submit")
    WebElement submitBtn;

    public JSExecutor typeNameEmailWithExecutor(String name,String email){
        if(name!=null && email!=null){
            js.executeScript("document.getElementById('userName').value='"+ name +"';");
            js.executeScript("document.getElementById('userName').style.border='1px solid red';");
            js.executeScript("document.getElementById('userEmail').value='"+ email +"';");
            System.out.println(uName.getAttribute(("value") + "By value"));
        }
        return this;
    }
    public JSExecutor clickOnSubmit(){
        js.executeScript("document.querySelector('#submit').style.backgroundColor = 'Red';");
        js.executeScript("document.querySelector('footer').style.display='none';");
        js.executeScript("document.getElementById('submit').click();");
        return this;
    }
    public JSExecutor refreshBrowserJSE(){
        js.executeScript("history.go(0)");
        return this;
    }
    public JSExecutor checkBoxJSE(){
        js.executeScript("document.getElementById('hobbies-checkbox-1').checked=true;");
        return this;
    }
    public JSExecutor alertWithJSE() {
        js.executeScript("alert('hello world!')");
        return this;
    }
    public JSExecutor scrollWithJSE(){
        js.executeScript("window.scrollBy()0,100");
        return this;
    }
    public JSExecutor getTitlePageJSE(){
        String text = js.executeScript("return document.title;").toString();
        System.out.println("********************" + "\n" + text);
        return this;
    }
    public JSExecutor getURLPageJSE() {
        String text = js.executeScript("return document.URL;").toString();
        System.out.println("URL --> " + text);
        return this;
    }
    public JSExecutor typeAgeToSearchPanel(int age){
        js.executeScript("document.getElementById('searchBox').value='"+ age +"';");
        return this;
    }
    public JSExecutor showNameByAge(int age){
        String name;
        if(age==39){
            name = "Vega";
        }else if(age==45){
            name = "Cantrell";
        }else
            name = "Gentry";
        js.executeScript("alert('we found " + name + "')");
        driver.switchTo().alert().accept();
        return this;
    }



}
