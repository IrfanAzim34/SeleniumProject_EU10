package com.cydeo.extraTask;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculatorTest extends TestBase {

    @Test
    public void calculate_Verify_GasMileage(){

        //2. Go to https://www.calculator.net
        driver.get("https://www.calculator.net ");

        //3. Search for “gas mileage” using search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));
        searchBox.sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalcBtn = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageCalcBtn.click();

        //5. On Next page verify:
            //a. Title equals: “Gas Mileage Calculator”
            //b. “Gas Mileage Calculator” label is displayed
        BrowserUtils.verifyTitle(driver,"Gas Mileage Calculator");
        String actualLabel = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']")).getText();
        String expectedLabel = "Gas Mileage Calculator";
        Assert.assertEquals(actualLabel, expectedLabel);

        driver.findElement(By.xpath("//a[.='US Units']")).click();

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometerBox = driver.findElement(By.xpath("//input[@name='uscodreading']"));
        currentOdometerBox.sendKeys(Keys.CONTROL + "a");
        currentOdometerBox.sendKeys(Keys.DELETE);
        currentOdometerBox.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousOdometerBox = driver.findElement(By.xpath("//input[@name='uspodreading']"));
        previousOdometerBox.sendKeys(Keys.CONTROL + "a");
        previousOdometerBox.sendKeys(Keys.DELETE);
        previousOdometerBox.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAddedBox = driver.findElement(By.xpath("//input[@name='usgasputin']"));
        gasAddedBox.sendKeys(Keys.CONTROL + "a");
        gasAddedBox.sendKeys(Keys.DELETE);
        gasAddedBox.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPrice = driver.findElement(By.xpath("//input[@name='usgasprice']"));
        gasPrice.sendKeys(Keys.CONTROL + "a");
        gasPrice.sendKeys(Keys.DELETE);
        gasPrice.sendKeys("3.55");

        //10. Click on Calculate button
        driver.findElement(By.xpath("//input[@value='Calculate'][1]")).click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        String actualValue = driver.findElement(By.xpath("//p[@class='verybigtext']//b")).getText();
        String expectedValue = "23.44 mpg";

        Assert.assertEquals(actualValue,expectedValue);

    }

}
