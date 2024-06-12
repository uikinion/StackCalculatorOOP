package CalculatorCommand;

import Calculator.Context;
import ExceptionPackage.RootOfNegativeNumberException;

public class Sqrt extends Operation {
    public Sqrt(String name) {
        super(name, 0, 1);
    }

    @Override
    protected void doAction(Context context, String[] args) throws RootOfNegativeNumberException{
        double operand = context.pop();
        context.push(Math.sqrt(operand));
        if (operand < 0) {
            throw new RootOfNegativeNumberException(operand);
        }
    }
}
