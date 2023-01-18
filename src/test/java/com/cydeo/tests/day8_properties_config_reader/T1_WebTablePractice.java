package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_WebTablePractice {

    @Test
    public void verifyDate(){
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");
//        2. Verify Bob’s name is listed as expected.
//            Expected: “Bob Martin”
        String expectedName = "Bob Martin";
        String actualName =
                Driver.getDriver().findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']")).getText();

        Assert.assertEquals(actualName,expectedName,"Expected name is not match");

//        3. Verify Bob Martin’s order date is as expected
//            Expected: 12/31/2021
        String expectedDate = "12/31/2021";
        WebTableUtils.orderVerify(Driver.getDriver(),"Bob Martin",expectedDate);

    }

}
