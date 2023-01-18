package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T5_WindowHandlePractice {

    @Test
    public void windowHandle(){
        Driver.getDriver().get("https://practice.cydeo.com/windows");
        //Storing the main page's window handle as string is a good practice for future re-usable purpose
        String mainHandle = Driver.getDriver().getWindowHandle();

        //4. Assert: Title is “Windows”
        String expectTitle = "Windows";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle,expectTitle);

        //5. Click to: “Click Here” link
        Driver.getDriver().findElement(By.xpath("//a[.='Click Here']")).click();

        //6. Switch to new Window.
        for (String each : Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);

        }

        //7. Assert: Title is “New Window”
        String expectTitle1 = "New Window";
        String actualTitle1 = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle1,expectTitle1);

    }

}
