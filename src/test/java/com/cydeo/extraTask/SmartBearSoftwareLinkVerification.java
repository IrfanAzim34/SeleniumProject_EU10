package com.cydeo.extraTask;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SmartBearSoftwareLinkVerification {

    @Test
    public void countOfLinks_PrintLinks(){

        //2. Go to website:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.logInSmartBear(Driver.getDriver());

        //6. Print out count of all the links on landing page
        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Count of Links = " + links.size());

        //7. Print out each link text on this page
        for (WebElement link : links) {
            System.out.println("Link Text = " + link.getText());
        }

    }

}
