package org.dng.repository;

import org.dng.Car;

import java.util.List;

public interface CarsRepositoryI {
    void makeNCars(int n);

    List<Car> findAll();

}
