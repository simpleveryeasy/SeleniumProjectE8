package com.cydeo.tests.day9_javaFaker_testbase_driverUtil;

public class Singleton {

    //create private constructor
    private Singleton(){}

    //create private static String prevent access and provide a getter
    private static String word;

    //this utility method will return the word in the way we want to deliver
    public static String getWord(){

        if (word == null){
            System.out.println("First time call. Word is null assigning value to it now");
            word = "something";
        }else {
            System.out.println("Word already has a value");
        }
        return word;
    }



}
