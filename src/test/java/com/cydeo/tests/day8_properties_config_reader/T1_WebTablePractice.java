package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTablePractice {

    WebDriver driver;


    @BeforeMethod
    public void setup(){
        //Go to: https://practice.cydeo.com/web-tables
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void verifyDate(){

//        2. Verify Bob’s name is listed as expected.
//            Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName =
                driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']")).getText();

        Assert.assertEquals(actualName,expectedName,"Expected name is not match");

//        3. Verify Bob Martin’s order date is as expected
//            Expected: 12/31/2021
        String expectedDate = "12/31/2021";
        WebTableUtils.orderVerify(driver,"Bob Martin",expectedDate);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
