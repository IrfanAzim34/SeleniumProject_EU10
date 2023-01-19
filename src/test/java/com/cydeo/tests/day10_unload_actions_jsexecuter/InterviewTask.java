package com.cydeo.tests.day10_unload_actions_jsexecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class InterviewTask {

    @Test
    public void test(){

        Driver.getDriver().get("https://todomvc.com/");

        Driver.getDriver().findElement(By.xpath("//div[.='JavaScript']")).click();
        Driver.getDriver().findElement(By.xpath("//a[.='Polymer']")).click();

        WebElement todoBox = Driver.getDriver().findElement(By.xpath("//input[@id='new-todo']"));

        todoBox.sendKeys("FirstToDo" + Keys.ENTER);
        todoBox.sendKeys("SecondToDo" + Keys.ENTER);

        WebElement secondTodoElement = Driver.getDriver().findElement(By.xpath("(//ul)[4]/li[2]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(secondTodoElement).doubleClick().sendKeys(" Finished" + Keys.ENTER).build().perform();

    }

}
