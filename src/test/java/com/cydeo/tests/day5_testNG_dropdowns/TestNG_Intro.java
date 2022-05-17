package com.cydeo.tests.day5_testNG_dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setupMethod(){
        System.out.println("----> BeforeClass is running...");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("----> AfterClass is running...");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("---> BeforeMethod is running... ");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("---> AfterMethod is running...");
    }

    @Test
    public void test1(){
        System.out.println("Test 1 is running...");

        //Assert Equals
        String actual = "apple";
        String expected = "apple";

        Assert.assertEquals(actual, expected);

    }



    @Test
    public void test2(){
        System.out.println("Test 2 is running...");

        //AssertTrue
        String actual = "apple";
        String expected = "apple";

        Assert.assertTrue(actual.equals(expected));
    }
}
