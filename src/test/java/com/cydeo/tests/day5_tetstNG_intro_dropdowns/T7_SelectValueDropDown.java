package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T7_SelectValueDropDown {

    @Test
    public void selectNonSelectDropDown(){
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
        //3. Click to non-select dropdown
        WebElement dropDownLinkButton = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-secondary dropdown-toggle']"));
        dropDownLinkButton.click();
        //4. Select Facebook from dropdown
        WebElement facebook = Driver.getDriver().findElement(By.xpath("//a[.='Facebook']"));
        facebook.click();
        //5. Verify title is “Facebook – Log In or Sign Up”
        String expectTitle = "Facebook – log in or sign up";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectTitle);
    }

}
