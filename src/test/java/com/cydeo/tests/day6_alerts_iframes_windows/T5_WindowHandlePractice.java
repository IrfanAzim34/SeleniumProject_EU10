package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowHandlePractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //2. Create new test and make setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Go to : https://practice.cydeo.com/windows
        driver.get("https://practice.cydeo.com/windows");
    }

    @Test
    public void windowHandle(){
        //Storing the main page's window handle as string is a good practice for future re-usable purpose
        String mainHandle = driver.getWindowHandle();

        //4. Assert: Title is “Windows”
        String expectTitle = "Windows";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectTitle);

        //5. Click to: “Click Here” link
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        //6. Switch to new Window.
        for (String each : driver.getWindowHandles()){
            driver.switchTo().window(each);

        }

        //7. Assert: Title is “New Window”
        String expectTitle1 = "New Window";
        String actualTitle1 = driver.getTitle();

        Assert.assertEquals(actualTitle1,expectTitle1);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
