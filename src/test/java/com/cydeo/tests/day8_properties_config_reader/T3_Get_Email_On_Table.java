package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.base.TestBase;
import com.cydeo.utilities.WebTableUtils;
import org.testng.annotations.Test;

public class T3_Get_Email_On_Table extends TestBase {

    @Test
    public void getEmailOnTable(){

        //2- Go to: https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");
        WebTableUtils.getTableGetEmail(driver,"2","John");

    }

}
