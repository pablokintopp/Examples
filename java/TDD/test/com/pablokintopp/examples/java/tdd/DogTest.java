package com.pablokintopp.examples.java.tdd;


import org.junit.Assert;
import org.junit.Test;

public class DogTest {

    @Test
    public void test(){
        Dog dog1 = new Dog();
        dog1.breed = "Cocker";
        dog1.size = "Médio";
        dog1.name = "Jack";

        Assert.assertEquals("AU AU!", dog1.bark());
        Assert.assertEquals("Name: Jack, Breed: Cocker, Size: Médio",dog1.toString());
    }
}
