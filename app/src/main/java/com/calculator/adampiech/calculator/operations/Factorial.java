package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-04-10.
 */
public class Factorial implements Operation {

    @Override
    public double count(double... args) {

        if (args[0] == 0 || args[0] == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 1; i <= args[0]; i++) {
            result *= i;
        }
        return result;
    }
}
