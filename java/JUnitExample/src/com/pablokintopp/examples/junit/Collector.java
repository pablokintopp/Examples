package com.pablokintopp.examples.junit;

import java.util.ArrayList;
import java.util.List;

public class Collector {

    private String name;
    private List<Car> carsCollection;

    public Collector(String name) {
        this.name = name;
        carsCollection = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Car> getCarsCollection() {
        return carsCollection;
    }

    public void addCar(Car car){ carsCollection.add(car); }


    //Should pass the test
    public Car getOldestCar(){
        Car oldestCar = null;
        for(Car car : carsCollection){
            if(oldestCar != null ){
                if(car.getReleaseYear() < oldestCar.getReleaseYear() ){
                    oldestCar = car;
                }
            }else{
                oldestCar = car;
            }
        }

        return oldestCar;


    }
}
