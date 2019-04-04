package com.dld.hll.financial;

import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class CarCreator implements InstanceCreator<Car> {
    public Car createInstance(Type type) {
        Car car = new Car();
        car.brand = "Toyota";
        return car;
    }
}