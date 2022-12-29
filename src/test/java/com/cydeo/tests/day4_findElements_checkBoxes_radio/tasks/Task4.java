package com.cydeo.tests.day4_findElements_checkBoxes_radio.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Task4 {

    public static void main(String[] args) {

        //Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //Locate all the links in the page.
        List<WebElement> webElements = driver.findElements(By.tagName("a"));

        //Print out the number of the links on the page.
        System.out.println("number of anchor web elements: " + webElements.size());

        // Print out the texts of the links.
        for (WebElement webElement : webElements) {
            System.out.println("Anchor Web Element Text: " + webElement.getText());
        }

        //Print out the HREF attribute values of the links
        for (WebElement webElement : webElements) {
            System.out.println("Anchor Web Elements Links: " + webElement.getAttribute("href"));
        }

        driver.close();

    }

}
