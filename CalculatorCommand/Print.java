package CalculatorCommand;

import Calculator.Context;

public class Print extends Operation {
    public Print(String name) {
        super(name, 0, 1);
    }

    @Override
    protected void doAction(Context context, String[] args) {
        double value = context.peek();
        printStream.println(value);
    }
}
