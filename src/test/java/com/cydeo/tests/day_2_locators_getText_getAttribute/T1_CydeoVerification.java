package com.cydeo.tests.day_2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {

    public static void main(String[] args) {

        // Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        // Verify URL contains
        String expectedURL = "cydeo";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedURL)) {
            System.out.println("URL verification PASSED!");
        }else {
            System.err.println("URL verification FAILED!!!");
        }

        //Verify title
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED!");
        }else {
            System.err.println("Title verification FAILED!!!");
        }

    }

}