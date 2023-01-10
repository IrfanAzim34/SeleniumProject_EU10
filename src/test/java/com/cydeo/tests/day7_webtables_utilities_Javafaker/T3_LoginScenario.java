package com.cydeo.tests.day7_webtables_utilities_Javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_LoginScenario {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //1. Create new test and make set ups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/ ");

    }

    @Test
    public void crm_login_test1(){
        /*
        3. Enter valid username
        4. Enter valid password
                                  USERNAME                  PASSWORD
                        helpdesk1@cybertekschool.com        UserUser
                        Helpdesk2@cybertekschool.com        UserUser
        5. Click to `Log In` button
        6. Verify title is as expected:
                Expected: My tasks
         */

        CRM_Utilities.login_crm(driver,"helpdesk1@cybertekschool.com","UserUser");
        BrowserUtils.verifyTitle(driver,"My tasks");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
