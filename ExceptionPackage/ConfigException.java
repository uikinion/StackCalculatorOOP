package ExceptionPackage;

import Calculator.CalculatorException;

public class ConfigException extends CalculatorException {
    public ConfigException(String message) {
        super(message);
    }
}
