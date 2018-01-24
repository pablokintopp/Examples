package com.pablokintopp.examples.junit;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class CollectorTest {

    @Test
    public void testGetOldestCar(){

        Collector pablo = new Collector("Pablo");

        Car car1 = new Car("Logan","Renault",2010, LocalDate.of(2011,10,1));
        Car car2 = new Car("Focus","Ford",2002, LocalDate.of(2006,5,1));
        Car car3 = new Car("Corsa","Chevrolet",2000, LocalDate.of(2000,2,1));

        pablo.addCar(car1);
        pablo.addCar(car2);
        pablo.addCar(car3);

        Assert.assertEquals(car3,pablo.getOldestCar());

    }
}
