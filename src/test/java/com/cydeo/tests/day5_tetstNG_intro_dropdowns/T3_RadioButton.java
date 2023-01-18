package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton {

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameValue, String idValue){

        List<WebElement> radioButtons = driver.findElements(By.name(nameValue));

        for (WebElement radioButton : radioButtons) {

            if (radioButton.getAttribute("id").equals(idValue)){

                radioButton.click();
                System.out.println(idValue + " is selected");
                break;
            }
        }

    }

    public static void main(String[] args) {

        WebDriver driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/radio_buttons");
        clickAndVerifyRadioButton(driver,"sport","hockey");


        driver.close();

    }

}
