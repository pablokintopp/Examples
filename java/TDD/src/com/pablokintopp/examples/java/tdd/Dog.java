package com.pablokintopp.examples.java.tdd;

public class Dog {
    public String breed;
    public String size;
    public String name;

    public String bark() {
        return  "AU AU!";
    }

    @Override
    public String toString() {
        return "Name: "+ name + ", " +"Breed: "+breed+ ", " +"Size: "+ size;
    }
}
