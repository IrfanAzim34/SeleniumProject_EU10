package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_SimpleDropDowns {

    @Test
    public void simpleDropDownTest(){
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        //3. Verify “Simple dropdown” default selected value is correct
        //      Expected: “Please select an option”
        Select simpleDropDown = new Select(Driver.getDriver().findElement(By.id("dropdown")));
        String actualSDT = simpleDropDown.getFirstSelectedOption().getText();
        String expectSDT = "Please select an option";
        Assert.assertEquals(actualSDT,expectSDT);

        //4. Verify “State selection” default selected value is correct
        //      Expected: “Select a State”
        Select stateDropDown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));
        String actualStateDD = stateDropDown.getFirstSelectedOption().getText();
        String expectStateDD = "Select a State";
        Assert.assertEquals(actualStateDD,expectStateDD);

    }

}
