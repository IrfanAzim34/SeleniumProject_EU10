package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class T4_Config_Practice extends TestBase {

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

}
