package com.cydeo.extraTask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CheckingTheNumOfLinks {

    @Test(priority = 1)
    public void numberOfLink(){

        //2. Go to https://www.openxcell.com
        //3. Count the number of the links on the page and verify
        //Expected: 332

        Driver.getDriver().get("https://www.openxcell.com");

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));

        System.out.println("Number Of Links = " + links.size());
        System.out.println("");

    }

    @Test(priority = 2)
    public void printOutTheTextOfLinks(){

        //2. Go to https://www.openxcell.com
        //3. Print out all of the texts of the links on the page
        Driver.getDriver().get("https://www.openxcell.com");

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        int a = 1;
        for (WebElement link : links) {
            System.out.println(a + ".Text of Link = " + link.getText());
            a++;
        }

        System.out.println("");

    }

    @Test(priority = 3)
    public void countNonTextLinks(){

        //2. Go to https://www.openxcell.com
        //3. Count the number of links that does not have text and verify
        //Expected: 109
        Driver.getDriver().get("https://www.openxcell.com");

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));

        int a = 0;
        for (WebElement link : links) {
            if (link.getText().isEmpty() || link.getText().isBlank() || link.getText() == null){
                a++;
            }
        }

        System.out.println("Number of Non-Text Links = " + a);

    }

}
