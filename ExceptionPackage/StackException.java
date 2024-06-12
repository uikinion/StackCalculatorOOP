package ExceptionPackage;

import Calculator.CalculatorException;

public class StackException extends CalculatorException {
    public StackException(String name, int needStackSize, int stackSize) {
        super(String.format("%s: expected at least %d " +
                "operands in the stack, but %d operands in the stack",
                name, needStackSize, stackSize));
    }
}
