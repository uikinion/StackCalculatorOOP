package ExceptionPackage;

import Calculator.CalculatorException;

public class ArgumentCountException extends CalculatorException {
    public ArgumentCountException(String name, int expectedCount, int givenCount) {
        super(String.format("%s: expected %d arguments, but %d given",
                name, expectedCount, givenCount));
    }
}
