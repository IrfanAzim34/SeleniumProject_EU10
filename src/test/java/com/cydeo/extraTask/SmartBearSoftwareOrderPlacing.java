package com.cydeo.extraTask;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SmartBearSoftwareOrderPlacing {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        //1. Open browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void verifyMsg(){

        //2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtils.logInSmartBear(driver);

        //6. Click on Order
        WebElement orderBtn = driver.findElement(By.xpath("//a[.='Order']"));
        orderBtn.click();

        //7. Select familyAlbum from product, set quantity to 2
        WebElement familyAlbum = driver.findElement(By.xpath("//option[.='FamilyAlbum']"));
        familyAlbum.click();

        WebElement quantityBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']"));
        quantityBox.sendKeys(Keys.CONTROL + "a");
        quantityBox.sendKeys(Keys.DELETE);
        quantityBox.sendKeys("2");

        //8. Click to “Calculate” button
        WebElement calculateBtn = driver.findElement(By.xpath("//input[@type='submit']"));
        calculateBtn.click();

        //9. Fill address Info with JavaFaker • Generate: name, street, city, state, zip code
        Faker faker = new Faker();

        WebElement nameBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        WebElement streetBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        WebElement cityBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox3']"));
        WebElement stateBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox4']"));
        WebElement zipBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox5']"));
        nameBox.sendKeys(faker.name().fullName());
        streetBox.sendKeys(faker.address().streetAddress());
        cityBox.sendKeys(faker.address().cityName());
        stateBox.sendKeys(faker.address().state());
        zipBox.sendKeys(faker.numerify("####"));

        //10. Click on “visa” radio button
        WebElement visaRadio = driver.findElement(By.xpath("//input[@value='Visa']"));
        visaRadio.click();

        //11. Generate card number using JavaFaker
        WebElement cardBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox6']"));
        cardBox.sendKeys(faker.numerify("################"));

        WebElement dateBox =
                driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox1']"));
        dateBox.sendKeys(faker.numerify("0#")+ "/" + faker.number().numberBetween(2022,2023));

        //12. Click on “Process”
        WebElement processBtn = driver.findElement(By.xpath("//a[.='Process']"));
        processBtn.click();

        //13. Verify success message “New order has been successfully added.”
        WebElement msg = driver.findElement(By.tagName("strong"));
        String expectedMsg = "New order has been successfully added.";
        String actualMsg = msg.getText();

        Assert.assertEquals(actualMsg,expectedMsg);

    }

    @AfterMethod
    public void tearDown(){

        driver.close();

    }

}
