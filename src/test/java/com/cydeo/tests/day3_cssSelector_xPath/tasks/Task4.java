package com.cydeo.tests.day3_cssSelector_xPath.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task4 {

    public static void main(String[] args) {

        //Open a chrome browser
        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        //Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        /*
        Verify “Reset password” button text is as expected:
        Expected: Reset password
         */
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

        String expectResetPasswordText = "Reset password";
        String actualResetPasswordText = resetPasswordButton.getText();

        if (actualResetPasswordText.equals(expectResetPasswordText)){
            System.out.println("PASS");
            System.out.println("expectResetPasswordText = " + expectResetPasswordText);
            System.out.println("actualResetPasswordText = " + actualResetPasswordText);
        }else {
            System.out.println("FAIL");
            System.out.println("expectResetPasswordText = " + expectResetPasswordText);
            System.out.println("actualResetPasswordText = " + actualResetPasswordText);
        }

        driver.close();

    }

}
