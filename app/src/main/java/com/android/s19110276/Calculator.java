package com.android.s19110276;

public class Calculator {
    public enum Operator {ADD, SUB, MUL, DIV, EXP, FACT, LOGA}

    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public double div(double firstOperand, double secondOperand) {
        return firstOperand / secondOperand;
    }

    public double exp(double firstOperand, double secondOperand) {
        return Math.pow(firstOperand, secondOperand);
    }

    public double fact(double firstOperand) {
        int answer = 1;
        for (int i = 1; i <= firstOperand; i++) {
            answer *= i;
        }
        if (answer == 0) return Double.POSITIVE_INFINITY;
        return answer;
    }

    public double loga(double firstOperand, double secondOperand) {
        return Math.log(secondOperand) / Math.log(firstOperand);
    }
}
