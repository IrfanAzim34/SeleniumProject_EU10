package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_LinkTextPractice {

    public static void main(String[] args) {

        // Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Go to: https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");

        // click to A/B Testing from top of the list
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();

         // Verify title
        String expectedTitle = "No A/B Test";
        String actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verifying PASSED!");
        }else{
            System.err.println("Title verifying FAILED!!!!");
        }

        driver.navigate().back();

        String expectedTitle1 = "Practice";
        String actualTitle1 = driver.getTitle();
        if (actualTitle1.equals(expectedTitle1)){
            System.out.println("Title verifying PASSED!");
        }else {
            System.err.println("Title verifying FAILED!!!!");
        }

    }

}
