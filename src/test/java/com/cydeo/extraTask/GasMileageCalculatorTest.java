package com.cydeo.extraTask;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculatorTest {

    @Test
    public void calculate_Verify_GasMileage(){

        //2. Go to https://www.calculator.net
        Driver.getDriver().get("https://www.calculator.net");

        //3. Search for “gas mileage” using search box
        WebElement searchBox = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalcBtn = Driver.getDriver().findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageCalcBtn.click();

        //5. On Next page verify:
            //a. Title equals: “Gas Mileage Calculator”
            //b. “Gas Mileage Calculator” label is displayed
        BrowserUtils.verifyTitle(Driver.getDriver(),"Gas Mileage Calculator");
        String actualLabel = Driver.getDriver().findElement(By.xpath("//h1[.='Gas Mileage Calculator']")).getText();
        String expectedLabel = "Gas Mileage Calculator";
        Assert.assertEquals(actualLabel, expectedLabel);

        Driver.getDriver().findElement(By.xpath("//a[.='US Units']")).click();

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometerBox = Driver.getDriver().findElement(By.xpath("//input[@name='uscodreading']"));
        currentOdometerBox.clear();
        currentOdometerBox.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometerBox = Driver.getDriver().findElement(By.xpath("//input[@name='uspodreading']"));
        previousOdometerBox.clear();
        previousOdometerBox.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAddedBox = Driver.getDriver().findElement(By.xpath("//input[@name='usgasputin']"));
        gasAddedBox.clear();
        gasAddedBox.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = Driver.getDriver().findElement(By.xpath("//input[@name='usgasprice']"));
        gasPrice.clear();
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        Driver.getDriver().findElement(By.xpath("//input[@value='Calculate'][1]")).click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        String actualValue = Driver.getDriver().findElement(By.xpath("//p[@class='verybigtext']//b")).getText();
        String expectedValue = "23.44 mpg";

        Assert.assertEquals(actualValue,expectedValue);

    }

}
