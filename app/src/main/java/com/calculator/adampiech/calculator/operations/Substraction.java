package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-03-14.
 */
public class Substraction implements Operation {

    @Override
    public double count(double... args) {
        return args[0] - args[1];
    }
}
