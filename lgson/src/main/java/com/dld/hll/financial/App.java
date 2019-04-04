package com.dld.hll.financial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        Car car = new Car();
        car.brand = "Rover";
        car.doors = 5;
        System.out.println(gson.toJson(car));


    }
}
