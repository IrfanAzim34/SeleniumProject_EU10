package com.cydeo.tests.day4_findElements_checkBoxes_radio.tasks;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Task1_2 {

    public static void main(String[] args) {

        // Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //“Home” link
        // locate homeLink using css selector
        WebElement homeLink1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink2 = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homeLink3 = driver.findElement(By.cssSelector("a[href='/']"));

        //"Forgot password" header
        // locate header using css selector: locate parent element and move down to h2
        WebElement header1 = driver.findElement(By.cssSelector("div[class='example'] > h2"));
        // locate header using xpath, and using element's text
        WebElement header2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        // “E-mail” text
        WebElement emailLabel1 = driver.findElement(By.xpath("//label[@for='email']"));

        // E-mail input box
        WebElement emailInput1 = driver.findElement(By.xpath("//input[@name='email']"));
        // locate input box xpath contains method
        WebElement emailInput2 = driver.findElement(By.xpath("//input[@name='email']"));

        //“Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.xpath("//button[@id='form_submit']"));

        //“Powered by Cydeo text
        WebElement poweredByCydeo = driver.findElement(By.xpath("//div[@style='text-align: center;']"));

        //Verify all web elements are displayed.
        System.out.println("homeLink1.isDisplayed() = " + homeLink1.isDisplayed());
        System.out.println("header1.isDisplayed() = " + header1.isDisplayed());
        System.out.println("emailLabel1.isDisplayed() = " + emailLabel1.isDisplayed());
        System.out.println("emailInput1.isDisplayed() = " + emailInput1.isDisplayed());
        System.out.println("retrievePasswordButton.isDisplayed() = " + retrievePasswordButton.isDisplayed());
        System.out.println("poweredByCydeo.isDisplayed() = " + poweredByCydeo.isDisplayed());

        driver.close();

    }

}
