package com.cydeo.tests.day10_unload_actions_jsexecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_ScrollPractice {

    @Test
    public void scroll1(){

        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

        //3- Scroll down to “Powered by CYDEO”
        //4- Scroll using Actions class “moveTo(element)” method
        Actions actions = new Actions(Driver.getDriver());
        WebElement cydeo = Driver.getDriver().findElement(By.xpath("//a[.='CYDEO']"));
        actions.moveToElement(cydeo).perform();
        BrowserUtils.sleep(2);
    }

    @Test
    public void scroll2(){

        //1- Continue from where the Task 4 is left in the same test.
        //2- Scroll back up to “Home” link using PageUP button
        WebElement homeBtn = Driver.getDriver().findElement(By.xpath("//a[.='Home']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(homeBtn).perform();

    }

}
