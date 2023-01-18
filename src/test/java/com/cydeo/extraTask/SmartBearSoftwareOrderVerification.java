package com.cydeo.extraTask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmartBearSoftwareOrderVerification {

    @Test
    public void verifyOrderDate(){
        //1. Open browser and login to Smartbear software
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        SmartBearUtils.logInSmartBear(Driver.getDriver());

        //2. Click on View all orders
        Driver.getDriver().findElement(By.xpath("//a[.='View all orders']")).click();

        //3. Verify Susan McLaren has order on date “01/05/2010”
        String expectedDate = "01/05/2010";
        String actualDate =
                Driver.getDriver().findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]")).getText();

        Assert.assertEquals(actualDate,expectedDate);

    }

}
