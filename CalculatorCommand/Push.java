package CalculatorCommand;

import Calculator.CalculatorException;
import Calculator.Context;
import ExceptionPackage.ArgumentTypeException;

public class Push extends InCommand {
    public Push(String name) {
        super(name, 1);
    }

    @Override
    protected void doAction(Context context, String[] args) throws ArgumentTypeException {
        Double value = context.identify(args[0]);
        if (value == null) {
            value = tryParseDouble(args[0]);
        }
        context.push(value);
    }

    public double tryParseDouble(String identifier) throws ArgumentTypeException {
        try {
            return Double.parseDouble(identifier);
        } catch (NumberFormatException exception) {
            throw new ArgumentTypeException("push", identifier, "double");
        }
    }
}
