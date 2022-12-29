package com.cydeo.tests.day3_cssSelector_xPath.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task5 {

    public static void main(String[] args) {

        //Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //Enter incorrect username into login box:
        WebElement loginBox = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]/div[1]/input"));
        loginBox.sendKeys("incorrect");

        //Click to `Reset password` button
        WebElement resetPasswordButton = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[4]/button"));
        resetPasswordButton.click();

        /*
        Verify “error” label is as expected
        Expected: Login or E-mail not found
         */
        String expectedErrorMsg = "Login or E-mail not found";
        String actualErrorMsg = driver.findElement(By.xpath("//*[@id=\"login-popup\"]/form/div[2]")).getText();

        if (actualErrorMsg.equals(expectedErrorMsg)){
            System.out.println("PASS");
            System.out.println("expectedErrorMsg = " + expectedErrorMsg);
            System.out.println("actualErrorMsg = " + actualErrorMsg);
        }else {
            System.out.println("FAIL");
            System.out.println("expectedErrorMsg = " + expectedErrorMsg);
            System.out.println("actualErrorMsg = " + actualErrorMsg);
        }

        driver.close();

    }

}
