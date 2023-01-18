package com.cydeo.tests.day7_webtables_utilities_Javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class T3_LoginScenario {

    @Test
    public void crm_login_test1(){
        Driver.getDriver().get("http://login1.nextbasecrm.com/ ");
        /*
        3. Enter valid username
        4. Enter valid password
                                  USERNAME                  PASSWORD
                        helpdesk1@cybertekschool.com        UserUser
                        Helpdesk2@cybertekschool.com        UserUser
        5. Click to `Log In` button
        6. Verify title is as expected:
                Expected: My tasks
         */

        CRM_Utilities.login_crm(Driver.getDriver(),"helpdesk1@cybertekschool.com","UserUser");
        BrowserUtils.verifyTitle(Driver.getDriver(),"My tasks");

    }

}
