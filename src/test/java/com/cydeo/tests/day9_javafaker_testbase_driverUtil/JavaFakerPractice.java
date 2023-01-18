package com.cydeo.tests.day9_javafaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){
        // Creating Faker object to reach methods
        Faker faker = new Faker(new Locale("fr"));

        System.out.println(faker.aviation().airport());
        System.out.println(faker.letterify("???????"));
        System.out.println(faker.numerify("536-####-####"));
        System.out.println(faker.finance().iban());
        System.out.println(faker.app().name());
        System.out.println(faker.chuckNorris().fact());



    }

}
