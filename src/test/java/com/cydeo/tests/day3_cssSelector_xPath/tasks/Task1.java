package com.cydeo.tests.day3_cssSelector_xPath.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/ ");

        WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));

        loginBox.sendKeys("Incorrect");

        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));

        passwordBox.sendKeys("incorrect");

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        String expectedErrorMessage = "Incorrect login or password";
        String actualErrorMessage = driver.findElement(By.className("errortext")).getText();

        if (expectedErrorMessage.equals(actualErrorMessage)){
            System.out.println("PASS");
            System.out.println("expectedErrorMessage = " + expectedErrorMessage);
            System.out.println("actualErrorMessage = " + actualErrorMessage);
        }else {
            System.out.println("FAIL");
            System.out.println("expectedErrorMessage = " + expectedErrorMessage);
            System.out.println("actualErrorMessage = " + actualErrorMessage);
        }

        driver.close();

    }

}
