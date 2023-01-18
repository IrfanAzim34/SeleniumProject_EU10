package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Selenium {

    @Test
    public void seleniumTest(){

        //Get "https://google.com"
        Driver.getDriver().get("https://google.com");

        //Assert: title is "Google"
        String expect = "Google";
        String actual = Driver.getDriver().getTitle();

        Assert.assertEquals(actual,expect,"if not match, print this message");

    }

}
