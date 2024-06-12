package ExceptionPackage;

import Calculator.CalculatorException;

public class ArithmeticException extends CalculatorException {
    public ArithmeticException(String message) {
        super(message);
    }
}
