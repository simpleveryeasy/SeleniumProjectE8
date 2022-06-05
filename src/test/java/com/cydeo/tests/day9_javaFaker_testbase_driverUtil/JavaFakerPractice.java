package com.cydeo.tests.day9_javaFaker_testbase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

public class JavaFakerPractice {

    @Test
    public void test1(){

        Faker faker = new Faker();

        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.name().lastName() = " + faker.name().lastName());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());

        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"312-###_####\") = " + faker.numerify("312-###_####"));

        System.out.println("faker.letterify(\"???-????\") = " + faker.letterify("???-????"));
        System.out.println("faker.letterify(\"???x???\") = " + faker.letterify("???x???"));

        System.out.println("faker.bothify(\"##?#-##?#-##?#-##?#\") = " + faker.bothify("##?#-##?#-##?#-##?#"));

        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
        System.out.println("faker.chuckNorris().fact() = " + faker.chuckNorris().fact());

        Faker faker2 = new Faker(new Locale("tr"));
        System.out.println("faker2.chuckNorris().fact() = " + faker2.chuckNorris().fact());

    }
}
