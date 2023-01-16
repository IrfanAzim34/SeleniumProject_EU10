package com.cydeo.extraTask;

import com.cydeo.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearSoftwareOrderVerification extends TestBase {

    @Test
    public void verifyOrderDate(){
        //1. Open browser and login to Smartbear software
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.logInSmartBear(driver);

        //2. Click on View all orders
        driver.findElement(By.xpath("//a[.='View all orders']")).click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        String expectedDate = "01/05/2010";
        String actualDate =
                driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]")).getText();

        Assert.assertEquals(actualDate,expectedDate);

    }

}
