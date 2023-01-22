package com.cydeo.tests.day11_actions_JSexecuter_practice;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_And_Drop {

    @Test
    public void dragAndDrop(){

        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Driver.getDriver().findElement(By.xpath("//button[.='Accept Cookies']")).click();

        //2. Drag and drop the small circle to bigger circle.
        WebElement smallCircle = Driver.getDriver().findElement(By.cssSelector("div#draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.cssSelector("div#droptarget"));

        Actions actions = new Actions(Driver.getDriver());
//        actions.dragAndDrop(smallCircle, bigCircle).perform();
        actions.clickAndHold(smallCircle).moveToElement(bigCircle).release().perform();

        //3. Assert:
        //-Text in big circle changed to: “You did great!”
        Assert.assertEquals(bigCircle.getText(),"You did great!");

        Driver.closeDriver();

    }

}
