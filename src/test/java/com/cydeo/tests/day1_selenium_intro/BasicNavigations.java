package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // 1- Set up the "browser driver"
        WebDriverManager.chromedriver().setup();

        // 2- Create instance of the Selenium WebDriver
        WebDriver driver = new ChromeDriver();
        // Maximizes the browser window
        driver.manage().window().maximize();

        // 3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        System.out.println("Tesla Title = " + driver.getTitle());
        System.out.println("Tesla URL = " + driver.getCurrentUrl());

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use selenium to navigate back
        driver.navigate().back();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use selenium to navigate forward
        driver.navigate().forward();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use selenium to navigate refresh
        driver.navigate().refresh();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // use navigate().to():
        driver.navigate().to("https://www.google.com");

        // Get the title of the page
        System.out.println("Google Title = " + driver.getTitle());

        // Get the URL of the page
        System.out.println("Google URL = " + driver.getCurrentUrl());

        // Close the browser window
        driver.close();

    }

}
