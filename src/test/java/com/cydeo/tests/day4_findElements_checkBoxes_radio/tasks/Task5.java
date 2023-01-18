package com.cydeo.tests.day4_findElements_checkBoxes_radio.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Task5 {

    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Go to http://practice.cydeo.com/checkboxes
        driver.get("http://practice.cydeo.com/checkboxes");

        //We have to locate checkBoxes
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@name='checkbox1']"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@name='checkbox2']"));

        //Confirm checkbox #1 is NOT selected by default
        if (checkBox1.isSelected()){
            System.out.println("FAIL!!!");
            System.out.println("Check Box 1 is selected");
        }else {
            System.out.println("PASS!");
            System.out.println("Check Box 1 is not selected");
        }

        //Confirm checkbox #2 is SELECTED by default.
        if (checkBox2.isSelected()){
            System.out.println("PASS!");
            System.out.println("Check box 2 is selected");
        }else {
            System.out.println("FAIL!!!");
            System.out.println("Check box 2 is not selected");
        }

        //Click checkbox #1 to select it.
        checkBox1.click();

        //Click checkbox #2 to deselect it.
        checkBox2.click();

        //Confirm checkbox #1 is SELECTED.
        if (checkBox1.isSelected()){
            System.out.println("PASS!");
            System.out.println("Check Box 1 is selected");
        }else {
            System.out.println("FAIL!!!");
            System.out.println("Check Box 1 is not selected");
        }

        //Confirm checkbox #2 is NOT selected.
        if (checkBox2.isSelected()){
            System.out.println("FAIL!!!");
            System.out.println("Check box 2 is selected");
        }else {
            System.out.println("PASS!");
            System.out.println("Check box 2 is not selected");
        }

        driver.close();

    }

}
