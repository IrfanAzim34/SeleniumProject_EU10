package com.cydeo.tests.day_2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_LibraryVerifications {

    public static void main(String[] args) {

        // Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Go to http://library2.cybertekschool.com/login.html
        driver.get("http://library2.cybertekschool.com/login.html");

        // Enter username: “incorrect@email.com”
        WebElement usernameInput = driver.findElement(By.className("form-control"));
        usernameInput.sendKeys("incorrect@email.com");

        // Enter password: “incorrect password”
        WebElement passwordBox = driver.findElement(By.id("inputPassword"));
        passwordBox.sendKeys("incorrect password");

        // Click sign in button
        WebElement signInButton = driver.findElement(By.tagName("button"));
        signInButton.click();

    }

}

/*
Locate username input box using “className” locator
Locate password input box using “id” locator
Locate Sign in button using “tagName” locator
 */