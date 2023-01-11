package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {

    public static String returnOrderDate(WebDriver driver, String costumerName){

        WebElement locator =
                driver.findElement(By.xpath("//td[.='" + costumerName + "']/following-sibling::td[3]"));

        return locator.getText();

    }

    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate){

        Assert.assertEquals(returnOrderDate(driver,costumerName),expectedOrderDate);


    }

    public static void getTableGetEmail(WebDriver driver, String tableNum, String firstName){

        WebElement emailCell =
                driver.findElement(By.xpath("//table[" + tableNum + "]//td[.='" + firstName + "']/following-sibling::td[1]"));

        System.out.println("Email = " + emailCell.getText());
    }

}
