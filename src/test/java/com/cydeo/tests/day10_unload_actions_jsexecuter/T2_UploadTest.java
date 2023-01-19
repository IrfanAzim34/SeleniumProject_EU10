package com.cydeo.tests.day10_unload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UploadTest {

    @Test
    public void uploadFileAndVerify(){

        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get("https://practice.cydeo.com/upload");

        //2. Find some small file from your computer, and get the path of it.
        String path = "C:\\Users\\erfan\\Desktop\\FL-Syllabus-2018-GA.pdf";

        //3. Upload the file.
        WebElement fileUpload = Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        fileUpload.sendKeys(path);

        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        //4. Assert:
        //-File uploaded text is displayed on the page
        String expectedMsg = "File Uploaded!";
        String actualMsg = Driver.getDriver().findElement(By.tagName("h3")).getText();

        Assert.assertEquals(actualMsg,expectedMsg,"Expected Message is not match");

    }

}
