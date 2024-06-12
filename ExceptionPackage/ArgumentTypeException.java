package ExceptionPackage;

import Calculator.CalculatorException;

public class ArgumentTypeException extends CalculatorException {
    public ArgumentTypeException(String name, String argument, String needTypeName) {
        super(String.format("%s: expected %s type argument, " +
                        "but %s is not %s",
                name, needTypeName, argument, needTypeName));
    }
}
