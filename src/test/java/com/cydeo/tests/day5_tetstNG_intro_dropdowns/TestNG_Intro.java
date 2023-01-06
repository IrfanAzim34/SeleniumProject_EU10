package com.cydeo.tests.day5_tetstNG_intro_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setupMethod(){
        System.out.println("---> Before Class is running...");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After Class is running...");
    }


    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> Before Method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> After Method is running...");
    }

    @Test(priority = 2)
    public void test1(){
        System.out.println("Test 1 is running...");
    }

    @Test(priority = 1)
    public void test2(){
        System.out.println("Test 2 is running...");

        // AssertEquals: compare 2 of the same things
        String actual = "actual",expect = "actual";
        Assert.assertEquals(actual,expect);

        // AsserTrue
        Assert.assertTrue(actual.equals(expect));

    }


}
