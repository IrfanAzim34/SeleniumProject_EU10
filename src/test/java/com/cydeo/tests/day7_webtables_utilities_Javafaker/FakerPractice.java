package com.cydeo.tests.day7_webtables_utilities_Javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerPractice {

    @Test
    public void fakerTest(){

        Faker faker = new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());

        System.out.println("faker.address().cityName() = " + faker.address().cityName());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.address().state() = " + faker.address().state());
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());

        System.out.println("faker.number().numberBetween(10000,90000) = " + faker.number().numberBetween(10000, 90000));
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("536-###-####"));

        System.out.println("faker.letterify(\"??? ???\") = " + faker.letterify("??? ???"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());

    }

}
