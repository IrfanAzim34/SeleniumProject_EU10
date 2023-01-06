package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_selectDateDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test
    public void selectDate(){
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        year.selectByVisibleText("1923");
        month.selectByValue("11");
        day.selectByIndex(0);

        String expectYear = "1923", expectMonth = "December", expectDay = "1";
        String actualYear = year.getFirstSelectedOption().getText();
        String actualMonth = month.getFirstSelectedOption().getText();
        String actualDay = day.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear,expectYear);
        Assert.assertEquals(actualMonth,expectMonth);
        Assert.assertEquals(actualDay,expectDay);
    }


    @AfterMethod
    public void close(){
        driver.close();
    }

}
