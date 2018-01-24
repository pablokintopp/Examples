package com.pablokintopp.examples.junit;

import java.time.LocalDate;

public class Car {

    private String model;
    private String brand;
    private int releaseYear;
    private LocalDate aquisitionDate;

    public Car(String model, String brand, int releaseYear, LocalDate aquisitionDate) {

        if(releaseYear > aquisitionDate.getYear()){
            throw new IllegalArgumentException("Year released cannot be bigger than aquisition year!");
        }
        this.model = model;
        this.brand = brand;
        this.releaseYear = releaseYear;
        this.aquisitionDate = aquisitionDate;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public LocalDate getAquisitionDate() {
        return aquisitionDate;
    }
}
