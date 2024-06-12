package ExceptionPackage;

public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super("division by zero");
    }
}
