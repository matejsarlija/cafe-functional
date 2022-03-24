package com.matej.learn;

public class Vehicle {
    int passengers;
    int fuelcap;
    int mpg;
    String name;

    // This is a constructor for Vehicle.
    Vehicle(int p, int f, int m) {
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    // Return the range
    int range() {
        return fuelcap * mpg;
    }

    // Compute fuel needed for given distance
    double fuelNeeded(int miles) {
        return (double) miles / mpg;
    }
}
