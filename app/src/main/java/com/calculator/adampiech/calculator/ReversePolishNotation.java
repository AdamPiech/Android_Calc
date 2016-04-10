package com.calculator.adampiech.calculator;

import android.util.Log;

import java.util.Stack;

/**
 * Created by Adam Piech on 2016-04-10.
 */
public class ReversePolishNotation {

    public String stringToRPN(String text) {

        String[] sings = text.split(" ");
        Stack<String> stack = new Stack<String>();
        String result = "";

        for (String sing : sings) {
            if (getOperatorPriority(sing) != 0) {
                while (!stack.empty() && getOperatorPriority(stack.peek()) >= getOperatorPriority(sing)) {
                    result += stack.pop() + " ";
//                    Log.d("#Znak#", result);
                }
                stack.push(sing);
            } else if ("(".equals(sing)) {
                stack.push(sing);
//                Log.d("#Nawias Lewy#", result);
            } else if (")".equals(sing)) {
                while (!"(".equals(stack.peek())) {
                    result += stack.pop() + " ";
                }
                stack.pop();
//                Log.d("#Nawias Prawy#", result);
            } else {
                result += sing + " ";
//                Log.d("#Liczba#", result);
            }
        }

        while(!stack.empty()) {
            result += stack.pop() + " ";
        }

        return result;
    }


    public String countRPN(String text) {

        Stack<Double> stack = new Stack<Double>();
        String[] sings = text.split(" ");

        for (String sing : sings) {
            if (getOperatorPriority(sing) == 0) {
                double value = Double.parseDouble(sing);
                stack.push(value);
                Log.d("#odlorzono#", sing);
            } else {
                double firstValue = stack.pop();
                double secondValue = stack.pop();
                switch(sing.charAt(0)) {
                    case '*': {stack.push(secondValue * firstValue); break;}
                    case '+': {stack.push(secondValue + firstValue); break;}
                    case '-': {stack.push(secondValue - firstValue); break;}
                    case '/': {stack.push(secondValue / firstValue); break;}
                }
                Log.d("#OBLICZENIA#", stack.peek().toString());
            }
        }
        return stack.pop().toString();
    }


    private int getOperatorPriority(String operator) {
        switch (operator) {
            case "sin(":
            case "cos(":
            case "tan(":
            case "log(":
            case "ln(":
            case "!":
            case "%":
                return 4;
            case "^":
            case "sqrt(":
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
