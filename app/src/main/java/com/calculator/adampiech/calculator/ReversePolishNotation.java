package com.calculator.adampiech.calculator;

import android.util.Log;

import java.util.Map;
import java.util.Stack;

/**
 * Created by Adam Piech on 2016-04-10.
 */
public class ReversePolishNotation {

    private Map<String, OperationArguments> operations;

    public ReversePolishNotation() {
        OperationExecutor executor = new OperationExecutor();
        this.operations = executor.getOperations();
    }

    public String stringToRPN(String text) {

        String[] sings = text.split(" ");
        Stack<String> stack = new Stack<String>();
        String result = "";

        for (String sing : sings) {
            if (getOperatorPriority(sing) != 0) {
                while (!stack.empty() && getOperatorPriority(stack.peek()) >= getOperatorPriority(sing)) {
                    result += stack.pop() + " ";
                }
                stack.push(sing);
            } else if ("(".equals(sing)) {
                stack.push(sing);
            } else if (")".equals(sing)) {
                while (!"(".equals(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.pop();
            } else {
                result += sing + " ";
            }
        }

        while(!stack.empty()) {
            result += stack.pop() + " ";
        }

        return result.trim();
    }


    public String countRPN(String text) {

        Stack<Double> stack = new Stack<Double>();
        String[] sings = text.split(" ");

        for (String sing : sings) {
            if (getOperatorPriority(sing) == 0) {
                double value = Double.parseDouble(sing);
                stack.push(value);
            } else {
                if (operations.get(sing).getHowMuchArgs() == 1) {
                    double value = stack.pop();
                    stack.push(operations.get(sing).getOperation().count(value));
                } else {
                    double secondValue = stack.pop();
                    double firstValue = stack.pop();
                    stack.push(operations.get(sing).getOperation().count(firstValue, secondValue));
                }
            }
        }
        return stack.pop().toString().trim().replace(".0", "");
    }


    private int getOperatorPriority(String operator) {
        switch (operator) {
            case "sin":
            case "cos":
            case "tan":
            case "log":
            case "ln":
            case "!":
            case "%":
                return 4;
            case "^":
            case "sqrt":
                return 3;
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                return 0;
        }
    }

}
