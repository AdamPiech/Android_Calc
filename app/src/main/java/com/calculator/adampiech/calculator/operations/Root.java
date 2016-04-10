package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-04-10.
 */
public class Root implements Operation {

    @Override
    public double count(double... args) {
        return Math.sqrt(args[0]);
    }
}
