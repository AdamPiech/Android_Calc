package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-04-10.
 */
public class Percent implements Operation {

    @Override
    public double count(double... args) {
        return args[0] / 100.0;
    }
}
