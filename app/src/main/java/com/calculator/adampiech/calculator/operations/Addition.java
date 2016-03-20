package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-03-14.
 */
public class Addition implements Operation {

    @Override
    public double count(double arg0, double arg1) {
        return arg0 + arg1;
    }
}
