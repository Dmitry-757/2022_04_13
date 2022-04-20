package org.dng.repository;

import org.dng.Car;

import java.util.ArrayList;
import java.util.List;

public class CarsRepository {
    private static List<Car> lCars;

    public static void makeNCars(int n) {
        List<Car> lc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Car c = new Car("x"+((int)(Math.random()*100)+100)+"yz", ((int)(Math.random()*100)+100), ((int)(Math.random()*10)+2010) );
            lc.add(c);
        }
        lCars = lc;
    }

    public static List<Car> findAll() {
        return lCars;
    }

    public static void setTax(double tax){
        Car.setTaxRate(tax);
    }

}
