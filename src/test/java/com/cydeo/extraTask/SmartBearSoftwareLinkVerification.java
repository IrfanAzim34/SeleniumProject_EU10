package com.cydeo.extraTask;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearSoftwareLinkVerification {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //1. Open browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void countOfLinks_PrintLinks(){

        //2. Go to website:http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.logInSmartBear(driver);

        //6. Print out count of all the links on landing page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Count of Links = " + links.size());

        //7. Print out each link text on this page
        for (WebElement link : links) {
            System.out.println("Link Text = " + link.getText());
        }

    }

    @AfterMethod
    public void tearDown(){

        driver.close();

    }

}
