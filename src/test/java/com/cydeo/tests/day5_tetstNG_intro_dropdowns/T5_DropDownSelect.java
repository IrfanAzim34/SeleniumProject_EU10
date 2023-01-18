package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class T5_DropDownSelect {

    @Test
    public void selectDropDown() {
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        //3. Select Illinois
        Select stateDropDown = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));
        stateDropDown.selectByIndex(15);
        //4. Select Virginia
        stateDropDown.selectByVisibleText("Virginia");
        //5. Select California
        stateDropDown.selectByValue("CA");
        //6. Verify final selected option is California.
        String expectedCalifornia = "California";
        String actualCalifornia = stateDropDown.getFirstSelectedOption().getText();

        //Use all Select options. (visible text, value, index)
    }

}
