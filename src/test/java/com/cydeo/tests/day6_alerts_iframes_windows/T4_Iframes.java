package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_Iframes {

    @Test
    public void iframe_test(){
        Driver.getDriver().get("https://practice.cydeo.com/iframe");
        //4. Assert: “Your content goes here.” Text is displayed.
//        WebElement iframe = Driver.getDriver().findElement(By.tagName("iframe"));
        Driver.getDriver().switchTo().frame(0);
        WebElement text = Driver.getDriver().findElement(By.xpath("//p[.='Your content goes here.']"));
        String expectTxt = "Your content goes here.";
        String actualTxt = text.getText();

        Assert.assertEquals(actualTxt,expectTxt,"Expected text is not Displayed!!!");
        Driver.getDriver().switchTo().parentFrame();

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        WebElement msg = Driver.getDriver().findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        String expectMsg = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualMsg = msg.getText();

        Assert.assertEquals(actualMsg,expectMsg,"Expected message is not Displayed!!!");
    }

}
