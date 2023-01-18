package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownPractices {

    @Test
    public void dropdown(){
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
        Select stateDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Illinois");
        stateDropdown.selectByValue("VA");
        stateDropdown.selectByIndex(5);

        String expectFinalSelected = "California";
        String actualFinalSelected = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualFinalSelected,expectFinalSelected);
    }

}
