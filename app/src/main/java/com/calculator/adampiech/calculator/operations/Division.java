package com.calculator.adampiech.calculator.operations;

/**
 * Created by Adam Piech on 2016-03-14.
 */
public class Division implements Operation {

    @Override
    public double count(double... args) {
        if (args[1] == 0.0) {
            throw new ArithmeticException("Nie mozna dzielić przez 0!");
        } else {
            return args[0] / args[1];
        }
    }
}
