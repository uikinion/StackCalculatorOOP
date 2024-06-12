package CalculatorCommand;

import Calculator.CalculatorException;
import Calculator.Command;
import Calculator.Context;
import ExceptionPackage.ArgumentCountException;
import ExceptionPackage.StackException;

public abstract class Operation extends Command {
    private final int argumentCount;
    private final int needStackSize;

    public Operation(String name, int argumentCount, int needStackSize) {
        super(name);
        this.argumentCount = argumentCount;
        this.needStackSize = needStackSize;
    }

    @Override
    public void apply(Context context, String[] args) throws CalculatorException {
        if (context.stackSize() < needStackSize)
            throw new StackException(getName(), needStackSize, context.stackSize());

        doAction(context, args);

        if (args.length != argumentCount)
            throw new ArgumentCountException(getName(), argumentCount, args.length);
    }

    protected abstract void doAction(Context context, String[] args) throws CalculatorException;
}
