package CalculatorCommand;

import Calculator.Context;

public class Mul extends Operation {
    public Mul(String name) {
        super(name, 0, 2);
    }

    @Override
    protected void doAction(Context context, String[] args) {
        double[] operand = context.pop(2);
        context.push(operand[0] * operand[1]);
    }
}