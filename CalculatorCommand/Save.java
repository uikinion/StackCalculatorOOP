package CalculatorCommand;

import Calculator.Context;

public class Save extends Operation {
    public Save(String name) {
        super(name, 1, 1);
    }

    @Override
    protected void doAction(Context context, String[] args) {
        double value = context.peek();
        context.define(args[0], value);
    }
}
