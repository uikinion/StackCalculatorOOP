package CalculatorCommand;

import Calculator.Context;
import ExceptionPackage.ArithmeticException;
import ExceptionPackage.DivisionByZeroException;

public class Div extends Operation {
    public Div(String name) {
        super(name, 0, 2);
    }

    @Override
    protected void doAction(Context context, String[] args) throws ArithmeticException {
        double[] operand = context.pop(2);
        context.push(operand[0] / operand[1]);
        if (operand[1] == 0) {
            throw new DivisionByZeroException();
        }
    }
}