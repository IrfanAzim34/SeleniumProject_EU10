package com.cydeo.tests.day7_webtables_utilities_Javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T1_WindowHandlePractice {

    @Test
    public void windowHandlingTest(){
        Driver.getDriver().get("https://www.amazon.com");
        //3. Copy paste the lines from below into your class
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) Driver.getDriver()).executeScript("window.open('https://facebook.com','_blank');");

        //4. Create a logic to switch to the tab where Etsy.com is open
//        Set<String> allTabs = Driver.getDriver().getWindowHandles();
//
//        for (String eachWindow : allTabs) {
//            Driver.getDriver().switchTo().window(eachWindow);
//            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());
//            if (Driver.getDriver().getCurrentUrl().contains("etsy")){
//                break;
//            }
//        }
//
//        //5. Assert: Title contains “Etsy”
//        String expectTitle = "Etsy";
//        String actualTitle = Driver.getDriver().getTitle();
//        Assert.assertTrue(actualTitle.contains(expectTitle),"Actual title is not match the expected title");

        BrowserUtils.switchWindowAndVerify(Driver.getDriver(),"Etsy.com","Etsy");

    }

}
