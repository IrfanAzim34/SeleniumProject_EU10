package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class T4_Config_Practice {

    @Test
    public void google_search_test(){
        //2- Go to: https://google.com
        Driver.getDriver().get("https://google.com");
        Driver.getDriver().findElement(By.xpath("//a[.='English']")).click();

        //3- Write “apple” in search box
        Driver.getDriver().findElement(By.xpath("//input[@name='q']")).sendKeys("apple" + Keys.ENTER);

        //4- Verify title:
        //Expected: apple - Google Search
        BrowserUtils.verifyTitle(Driver.getDriver(),"apple - Google Search");

    }

}
