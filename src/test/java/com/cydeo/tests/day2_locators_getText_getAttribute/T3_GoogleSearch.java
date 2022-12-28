package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {

    public static void main(String[] args) {

        // open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // go to https://www.google.com
        driver.get("https://www.google.com");

        // Write "apple" in search box
        // Press enter using Keys.ENTER
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);

        //Verify title
        String expectTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectTitle)){
            System.out.println("Title verifying PASSED!");
        }else {
            System.err.println("Title verifying FAILED!!!");
        }

    }

}
