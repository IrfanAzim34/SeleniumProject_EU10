package com.cydeo.utilities;
/*
In this class only general utility method that are not related to some specific page.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    /*
    1. Create a new class called BrowserUtils
    2. Create a method to make Task1 logic re-usable
    3. When method is called, it should switch window and verify title.


    Method info:
            • Name: switchWindowAndVerify
            • Return type: void
            • Arg1: WebDriver
            • Arg2: String expectedInUrl
            • Arg3: String expectedTitle

     */

    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){

        Set<String> allTabs = driver.getWindowHandles();

        for (String eachWindow : allTabs) {
            driver.switchTo().window(eachWindow);
            System.out.println("Current URL: " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }

        //5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),"Actual title is not match");

    }

    /*
    This method accept a String "expectedTitle" and Asserts if it is true
     */
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }

    public static void sleep(int second){
        try{
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    //Creating a utility method for ExplicitWait, so we don't have to repeat the lines
    public static void waitForInvisibilityOf(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

}
