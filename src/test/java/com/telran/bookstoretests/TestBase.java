package com.telran.bookstoretests;

import com.telran.pages.MyListener;
import com.telran.pages.PageBase;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase {

    //WebDriver driver;
    public EventFiringWebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod(alwaysRun = true)
    public void startTest(Method m, Object[] p) {
        logger.info("start test" + m.getName());
        if(p.length !=0)
            logger.info("--> with data: " + Arrays.asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(ITestResult result){
        if(result.isSuccess()){
            logger.info("Test result: PASSED");

        }else{
            logger.error("Test result: FAILED");
            String screen ="screenshots/screen-" + (System.currentTimeMillis()/1000%3600) + ".png";
            new PageBase(driver).takeScreenshot(screen);
        }
        logger.info("stop test: " + result.getMethod().getMethodName());
        logger.info("================================================================================");
    }

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "//Users/korypaev/Desktop/Tools/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new MyListener());
        driver.get("https://demoqa.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
