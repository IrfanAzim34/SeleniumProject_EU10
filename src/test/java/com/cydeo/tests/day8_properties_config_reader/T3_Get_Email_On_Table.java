package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebTableUtils;
import org.testng.annotations.Test;

public class T3_Get_Email_On_Table {

    @Test
    public void getEmailOnTable(){

        //2- Go to: https://practice.cydeo.com/tables
        Driver.getDriver().get("https://practice.cydeo.com/tables");
        WebTableUtils.getTableGetEmail(Driver.getDriver(),"2","John");

    }

}
