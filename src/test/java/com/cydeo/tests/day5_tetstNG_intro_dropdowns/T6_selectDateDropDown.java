package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T6_selectDateDropDown {

    @Test(priority = 1)
    public void selectYear(){
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
        Select year = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1924");
        String expectYear = "1924";
        String actualYear = year.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear,expectYear);
    }

    @Test(priority = 2)
    public void selectMonth(){
        Select month = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        String expectMonth = "December";
        String actualMonth = month.getFirstSelectedOption().getText();
        Assert.assertEquals(actualMonth,expectMonth);
    }

    @Test(priority = 3)
    public void selectDay(){
        Select day = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
        String expectDay = "1";
        String actualDay = day.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDay,expectDay);
    }
}
