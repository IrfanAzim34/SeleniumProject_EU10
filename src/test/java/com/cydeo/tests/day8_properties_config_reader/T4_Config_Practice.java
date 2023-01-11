package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Config_Practice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
//        driver = WebDriverFactory.getDriver("chrome");
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void google_search_test(){

        //2- Go to: https://google.com
        driver.get("https://google.com");
        driver.findElement(By.xpath("//a[.='English']")).click();

        //3- Write “apple” in search box
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("apple" + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        BrowserUtils.verifyTitle(driver,"apple - Google Search");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();

    }

}
