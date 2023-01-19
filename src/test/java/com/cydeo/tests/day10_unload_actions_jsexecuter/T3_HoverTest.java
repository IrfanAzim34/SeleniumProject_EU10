package com.cydeo.tests.day10_unload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_HoverTest {

    @Test
    public void hoverAndVerifyTest() throws InterruptedException {

        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");

        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        WebElement username1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement username2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement username3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        WebElement viewProfile1 = Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[1]"));
        WebElement viewProfile2 = Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[2]"));
        WebElement viewProfile3 = Driver.getDriver().findElement(By.xpath("(//a[.='View profile'])[3]"));

        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(image1).perform();

        //3. Assert:
            //a. “name: user1” is displayed
            //b. “view profile” is displayed
        Assert.assertTrue(username1.isDisplayed());
        Assert.assertTrue(viewProfile1.isDisplayed());

        //4. Hover over to second image
        actions.moveToElement(image2).perform();


        //5. Assert:
            //a. “name: user2” is displayed
            //b. “view profile” is displayed
        Assert.assertTrue(username2.isDisplayed());
        Assert.assertTrue(viewProfile2.isDisplayed());

        //6. Hover over to third image
        actions.moveToElement(image3).perform();

        //7. Confirm:
            //a. “name: user3” is displayed
            //b. “view profile” is displayed
        Assert.assertTrue(username3.isDisplayed());
        Assert.assertTrue(viewProfile3.isDisplayed());

    }

}
