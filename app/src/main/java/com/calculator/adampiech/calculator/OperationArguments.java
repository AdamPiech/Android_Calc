package com.calculator.adampiech.calculator;

import com.calculator.adampiech.calculator.operations.Operation;

/**
 * Created by Adam Piech on 2016-04-18.
 */
public class OperationArguments {

    private Operation operation;
    private int howMuchArgs;

    public OperationArguments(Operation operation, int howMuchArgs) {
        this.operation = operation;
        this.howMuchArgs = howMuchArgs;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getHowMuchArgs() {
        return howMuchArgs;
    }
}
