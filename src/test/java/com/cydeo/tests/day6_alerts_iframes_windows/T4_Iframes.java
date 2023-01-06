package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_Iframes {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        //2. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //3. Go to: https://practice.cydeo.com/iframe
        driver.get("https://practice.cydeo.com/iframe");
    }

    @Test
    public void iframe_test(){
        //4. Assert: “Your content goes here.” Text is displayed.
//        WebElement iframe = driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        String expectTxt = "Your content goes here.";
        String actualTxt = text.getText();

        Assert.assertEquals(actualTxt,expectTxt,"Expected text is not Displayed!!!");
        driver.switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        WebElement msg = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String expectMsg = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualMsg = msg.getText();

        Assert.assertEquals(actualMsg,expectMsg,"Expected message is not Displayed!!!");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
