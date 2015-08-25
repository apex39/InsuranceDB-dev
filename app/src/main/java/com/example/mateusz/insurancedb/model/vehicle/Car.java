package com.example.mateusz.insurancedb.model.vehicle;

/**
 * Created by mateusz on 27.12.14.
 */
public class Car extends Vehicle {
    public Car(String registrationNumber, String model, String brand, float capacity, String vin) {
        this.registrationNumber = registrationNumber;
        this.model = model;
        this.brand = brand;
        this.capacity = capacity;
        setVin(vin);
    }
}
