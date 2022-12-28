package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) {

        // Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        /*
            Verify header text is as expected:
            Expected: Registration form
         */
        String expectedHeaderText = "Registration form";
        WebElement headerText = driver.findElement(By.tagName("h2"));
        String actualHeaderText = headerText.getText();

        if (actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Header Text Verifying PASSED!");
        }else {
            System.err.println("Header Text Verifying FAILED!!!");
        }

        /*
            Locate “First name” input box
            Verify placeholder attribute’s value is as expected:
            Expected: first name
         */
        WebElement firstnameInput = driver.findElement(By.name("firstname"));
        String expectedFirstnamePlaceHolder = "first name";
        String actualFirstnamePlaceHolder = firstnameInput.getAttribute("placeholder");

        if (actualFirstnamePlaceHolder.equals(expectedFirstnamePlaceHolder)){
            System.out.println("PlaceHolderValue verifying PASSED!");
        }else {
            System.err.println("PlaceHolderValue verifying FAILED!!!");
        }

    }

}
