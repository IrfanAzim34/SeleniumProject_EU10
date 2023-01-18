package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_2_3_ConfirmationAlertPractice {

    @Test(priority = 1)
    public void confirmationAlert(){
        Driver.getDriver().get("http://practice.cydeo.com/javascript_alerts");
        //3. Click to “Click for JS Confirm” button
        Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        //4. Click to OK button from the alert
        Driver.getDriver().switchTo().alert().accept();

        //5. Verify “You clicked: Ok” text is displayed.
        WebElement msg = Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String actualMsg = msg.getText();
        String expectMsg = "You clicked: Ok";

        Assert.assertEquals(actualMsg,expectMsg,"Result text is not Displayed!!!");
    }

    @Test(priority = 2)
    public void informationAlert1(){
        //3. Click to “Click for JS Alert” button
        Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        //4. Click to OK button from the alert
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        String exceptMsg = Driver.getDriver().findElement(By.xpath("//p[@id='result']")).getText();
        String actualMsg = "You successfully clicked an alert";

        Assert.assertEquals(actualMsg,exceptMsg);
    }

    @Test(priority = 3)
    public void informationAlert2(){
        //3. Click to “Click for JS Prompt” button
        Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        //4. Send “hello” text to alert
        Driver.getDriver().switchTo().alert().sendKeys("hello");

        //5. Click to OK button from the alert
        Driver.getDriver().switchTo().alert().accept();

        //6. Verify “You entered:  hello” text is displayed.
        String expectMsg = "You entered: hello";
        String actualMsg = Driver.getDriver().findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(actualMsg,expectMsg,"Expected text is not Displayed");
    }

}
