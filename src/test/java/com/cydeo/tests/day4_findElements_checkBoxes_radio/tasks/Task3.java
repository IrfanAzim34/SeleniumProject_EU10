package com.cydeo.tests.day4_findElements_checkBoxes_radio.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task3 {

    public static void main(String[] args) {

        //Open Chrome browser
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //Click on Button 1
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        button1.click();

        //Verify text displayed is as expected:
        //Expected: “Clicked on button one!”
        String expectedText = "Clicked on button one!";
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();

        if (actualText.equals(expectedText)){
            System.out.println("PASSED!\tResult Text is match");
        }else {
            System.out.println("FAIL!!!\tResult Text is not match");
        }

        driver.close();

    }

}
