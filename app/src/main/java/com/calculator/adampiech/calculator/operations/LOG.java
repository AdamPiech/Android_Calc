package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-04-10.
 */
public class LOG implements Operation {

    @Override
    public double count(double... args) {
        return Math.log10(args[0]);
    }
}