package CalculatorCommand;

import Calculator.Context;

public class Pop extends Operation {
    public Pop(String name) {
        super(name, 0, 1);
    }

    @Override
    protected void doAction(Context context, String[] args) {
        double value = context.pop();
        printStream.println(value);
    }
}
