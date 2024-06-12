package CalculatorCommand;

import Calculator.Context;

public class Define extends InCommand {
    public Define(String name) {
        super(name, 2);
    }

    @Override
    protected void doAction(Context context, String[] args) {
        context.define(args[0], Double.parseDouble(args[1]));
    }
}
