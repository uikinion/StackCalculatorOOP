package CalculatorCommand;

import Calculator.CalculatorException;
import Calculator.Command;
import Calculator.Context;
import ExceptionPackage.ArgumentCountException;

public abstract class InCommand extends Command {
    private final int argumentCount;

    public InCommand(String name, int argumentCount) {
        super(name);
        this.argumentCount = argumentCount;
    }
    @Override
    public void apply(Context context, String[] args) throws CalculatorException {
        if (args.length != argumentCount)
            throw new ArgumentCountException(getName(), argumentCount, args.length);
        doAction(context, args);
    }

    protected abstract void doAction(Context context, String[] args) throws CalculatorException;
}
