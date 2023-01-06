package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T6_selectDateDropDown {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @Test(priority = 1)
    public void selectYear(){
        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1923");
        String expectYear = "1923";
        String actualYear = year.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear,expectYear);
    }

    @Test(priority = 2)
    public void selectMonth(){
        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        String expectMonth = "December";
        String actualMonth = month.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth,expectMonth);
    }

    @Test(priority = 3)
    public void selectDay(){
        Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
        String expectDay = "1";
        String actualDay = day.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay,expectDay);
    }


    @AfterClass
    public void close(){
        driver.close();
    }

}
