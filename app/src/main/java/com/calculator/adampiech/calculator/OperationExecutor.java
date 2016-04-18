package com.calculator.adampiech.calculator;

import com.calculator.adampiech.calculator.operations.Addition;
import com.calculator.adampiech.calculator.operations.COS;
import com.calculator.adampiech.calculator.operations.Division;
import com.calculator.adampiech.calculator.operations.Factorial;
import com.calculator.adampiech.calculator.operations.LN;
import com.calculator.adampiech.calculator.operations.LOG;
import com.calculator.adampiech.calculator.operations.Multiplication;
import com.calculator.adampiech.calculator.operations.Percent;
import com.calculator.adampiech.calculator.operations.Power;
import com.calculator.adampiech.calculator.operations.Root;
import com.calculator.adampiech.calculator.operations.SIN;
import com.calculator.adampiech.calculator.operations.Substraction;
import com.calculator.adampiech.calculator.operations.TAN;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adam Piech on 2016-04-18.
 */
public class OperationExecutor {

    private Map<String, OperationArguments> operations;

    public OperationExecutor() {
        this.operations = new HashMap<>();
        setOperations();
    }

    private void setOperations() {
        operations.put("sin", new OperationArguments(new SIN(), 1));
        operations.put("cos", new OperationArguments(new COS(), 1));
        operations.put("tan", new OperationArguments(new TAN(), 1));
        operations.put("log", new OperationArguments(new LOG(), 1));
        operations.put("ln", new OperationArguments(new LN(), 1));
        operations.put("!", new OperationArguments(new Factorial(), 1));
        operations.put("%", new OperationArguments(new Percent(), 1));
        operations.put("^", new OperationArguments(new Power(), 2));
        operations.put("sqrt", new OperationArguments(new Root(), 1));
        operations.put("*", new OperationArguments(new Multiplication(), 2));
        operations.put("/", new OperationArguments(new Division(), 2));
        operations.put("+", new OperationArguments(new Addition(), 2));
        operations.put("-", new OperationArguments(new Substraction(), 2));
    }

    public Map<String, OperationArguments> getOperations() {
        return operations;
    }

}
