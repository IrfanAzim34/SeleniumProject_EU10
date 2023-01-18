package com.cydeo.tests.day3_cssSelector_xPath.tasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Task2 {

    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();

        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        String expectedRememberMe = "Remember me on this computer";
        String actualRememberMe = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (expectedRememberMe.equals(actualRememberMe)){
            System.out.println("PASS");
            System.out.println("expectedRememberMeText = " + expectedRememberMe);
            System.out.println("actualRememberMeText = " + actualRememberMe);
        }else {
            System.out.println("FAIL");
            System.out.println("expectedRememberMeText = " + expectedRememberMe);
            System.out.println("actualRememberMeText = " + actualRememberMe);
        }

        String expectedForgotPassword = "Forgot your password?";
        String actualForgotPassword = driver.findElement(By.className("login-link-forgot-pass")).getText();

        if (expectedForgotPassword.equals(actualForgotPassword)){
            System.out.println("PASS");
            System.out.println("expectedForgotPassword = " + expectedForgotPassword);
            System.out.println("actualForgotPassword = " + actualForgotPassword);
        }else {
            System.out.println("FAIL");
            System.out.println("expectedForgotPassword = " + expectedForgotPassword);
            System.out.println("actualForgotPassword = " + actualForgotPassword);
        }

        String expectedForgotPassword1 = "forgot_password=yes";
        String actualForgotPassword1 = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");

        if (actualForgotPassword1.contains(expectedForgotPassword1)){
            System.out.println("PASS");
            System.out.println("expectedForgotPassword_HREF = " + expectedForgotPassword1);
            System.out.println("actualForgotPassword_HDEF = " + actualForgotPassword1);
        }else {
            System.out.println("FAIL");
            System.out.println("expectedForgotPassword_HREF = " + expectedForgotPassword1);
            System.out.println("actualForgotPassword_HDEF = " + actualForgotPassword1);
        }

        driver.close();
    }

}
