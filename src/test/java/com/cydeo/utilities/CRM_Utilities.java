package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    public static void login_crm(WebDriver driver){
        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernameInputBox.sendKeys("helpdesk1@cybertekschool.com");

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys("UserUser");

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

    public static void login_crm(WebDriver driver, String username, String password){
        WebElement usernameInputBox = driver.findElement(By.xpath("//input[@type='text']"));
        usernameInputBox.sendKeys(username);

        WebElement passwordInputBox = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInputBox.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }

}
