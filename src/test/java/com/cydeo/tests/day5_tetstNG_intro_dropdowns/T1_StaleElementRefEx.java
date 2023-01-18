package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));
        addElementBtn.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteBtn = driver.findElement(By.xpath("//button[.='Delete']"));
        if (deleteBtn.isDisplayed())
            System.out.println("Delete Button is displayed, PASS!");
        else
            System.out.println("Delete Button is not Displayed, FAIL!!!");

        //5. Click to “Delete” button.
        deleteBtn.click();

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("Delete Button Displayed = " + deleteBtn.isDisplayed());
            System.out.println("Delete Button is Displayed, FAIL!!!");
        }catch (StaleElementReferenceException e){
            System.out.println("Delete Button is not Displayed, PASS!");
        }

        driver.close();

    }

}
