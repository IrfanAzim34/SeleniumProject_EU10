package com.cydeo.extraTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

    public static void logInSmartBear(WebDriver driver){

        WebElement usernameBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernameBox.sendKeys("Tester");


        WebElement passwordBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordBox.sendKeys("test");


        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        loginBtn.click();

    }

}
