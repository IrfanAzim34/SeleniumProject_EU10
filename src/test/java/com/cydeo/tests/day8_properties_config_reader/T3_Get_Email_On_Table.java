package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_Get_Email_On_Table {
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void getEmailOnTable(){

        //2- Go to: https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");
        WebTableUtils.getTableGetEmail(driver,"2","John");

    }

    @AfterMethod
    public void tearDown(){

        driver.close();

    }

}
