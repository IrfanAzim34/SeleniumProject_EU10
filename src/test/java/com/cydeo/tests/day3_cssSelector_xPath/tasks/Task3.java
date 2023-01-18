package com.cydeo.tests.day3_cssSelector_xPath.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task3 {

    public static void main(String[] args) {

        // Open a Chrome browser
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        // Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        /*
        Verify “Log in” button text is as expected:
        Expected: Log In
         */
        WebElement loginButton = driver.findElement(By.cssSelector("input[class = 'login-btn']"));
        String actualButtonText = loginButton.getAttribute("value");
        String expectButtonText = "Log In";

        if (actualButtonText.equals(expectButtonText)){
            System.out.println("PASS");
            System.out.println("actualButtonText = " + actualButtonText);
            System.out.println("expectButtonText = " + expectButtonText);
        }else {
            System.out.println("FAIL");
            System.out.println("actualButtonText = " + actualButtonText);
            System.out.println("expectButtonText = " + expectButtonText);
        }

        driver.close();

    }

}
