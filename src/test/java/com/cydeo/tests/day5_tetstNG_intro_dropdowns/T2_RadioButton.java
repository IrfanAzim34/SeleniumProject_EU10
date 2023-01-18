package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T2_RadioButton {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //3. Click to “Hockey” radio button
        WebElement hockeyRadioButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        hockeyRadioButton.click();

        //4. Verify “Hockey” radio button is selected after clicking.
        if (hockeyRadioButton.isSelected())
            System.out.println("Button is selected, Verification PASSED!");
        else
            System.out.println("Button is not selected, Verification FAIL!!!");

        driver.close();

    }

}
