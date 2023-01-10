package com.cydeo.tests.day7_webtables_utilities_Javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandlePractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");
    }

    @Test
    public void windowHandlingTest(){

        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
//        Set<String> allTabs = driver.getWindowHandles();
//
//        for (String eachWindow : allTabs) {
//            driver.switchTo().window(eachWindow);
//            System.out.println("Current URL: " + driver.getCurrentUrl());
//            if (driver.getCurrentUrl().contains("etsy")){
//                break;
//            }
//        }
//
//        //5. Assert: Title contains “Etsy”
//        String expectTitle = "Etsy";
//        String actualTitle = driver.getTitle();
//        Assert.assertTrue(actualTitle.contains(expectTitle),"Actual title is not match the expected title");

        BrowserUtils.switchWindowAndVerify(driver,"Etsy.com","Etsy");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
