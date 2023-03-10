package com.cydeo.tests.day2_locators_getText_getAttribute.homeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_ZeroBankHeaderVerification {

    public static void main(String[] args) {

        // Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        /*
        Verify header text
        Expected: “Log in to ZeroBank”
         */
        String actualLogInHeaderText = driver.findElement(By.className("page-header")).getText();
        String expectedLogInHeaderText = "Log in to ZeroBank";

        if (actualLogInHeaderText.equals(expectedLogInHeaderText)){
            System.out.println("HeaderText Verification PASSED!");
        }else {
            System.err.println("HeaderText Verification FAILED!!!");
        }

    }

}
