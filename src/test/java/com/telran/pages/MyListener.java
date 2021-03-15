package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


public class MyListener extends AbstractWebDriverEventListener {
    public MyListener(){

    }

    Logger logger = (Logger) LoggerFactory.getLogger(MyListener.class);

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Start search" + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info(by  + "found.");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.error(throwable.toString());
        PageBase pageBase = new PageBase(driver);
    }
}

