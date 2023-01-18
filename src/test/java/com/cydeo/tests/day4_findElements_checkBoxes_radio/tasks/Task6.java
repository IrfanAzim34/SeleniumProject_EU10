package com.cydeo.tests.day4_findElements_checkBoxes_radio.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task6 {

    public static void main(String[] args) {

        //Open a chrome browser
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //Locate “CYDEO” link, verify it is displayed.
        WebElement cydeoLink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        //Refresh the page.
        driver.navigate().refresh();

        //We are refreshing the web element's reference by re-assigning the web element
        cydeoLink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        //Verify it is displayed, again.
        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        driver.close();

    }

}
