package com.example.samramezanli.pizzadelivery;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Coordinate {

    private int xValue;
    private int yValue;

    public Coordinate(int x_value, int yValue) {
        this.xValue = x_value;
        this.yValue = yValue;
    }

    public int getXValue() {
        return xValue;
    }

    public int getYValue() {
        return yValue;
    }

    public static List<Coordinate> getTestCoordinates() {

        List<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(0, 0));
        coordinates.add(new Coordinate(1, 3));
        coordinates.add(new Coordinate(4, 4));
        coordinates.add(new Coordinate(4, 2));
        coordinates.add(new Coordinate(4, 2));
        coordinates.add(new Coordinate(0, 1));
        coordinates.add(new Coordinate(3, 2));
        coordinates.add(new Coordinate(2, 3));
        coordinates.add(new Coordinate(4, 1));

        return coordinates;
    }
}