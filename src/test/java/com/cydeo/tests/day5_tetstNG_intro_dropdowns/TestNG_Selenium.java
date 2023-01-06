package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //Open Browser
        driver = WebDriverFactory.getDriver("chrome");
        //Maximize the page
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void seleniumTest(){

        //Get "https://google.com"
        driver.get("https://google.com");

        //Assert: title is "Google"
        String expect = "Googlee";
        String actual = driver.getTitle();

        Assert.assertEquals(actual,expect,"if not match, print this message");

    }

    @AfterMethod
    public void close(){
        driver.close();
    }

}
