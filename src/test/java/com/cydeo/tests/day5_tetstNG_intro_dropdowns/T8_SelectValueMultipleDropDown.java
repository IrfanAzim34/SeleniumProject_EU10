package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class T8_SelectValueMultipleDropDown {

    @Test
    public void selectValueMultipleDropDown() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");

        //3. Select all the options from multiple select dropdown.
        Select languages = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> webElementList = languages.getOptions();

        //4. Print out all selected values.
        for (WebElement webElement : webElementList) {
            webElement.click();
        }

        for (WebElement webElement : webElementList) {
            System.out.println(webElement.getAttribute("value"));
        }
        //5. Deselect all values.
        languages.deselectAll();

    }

}
