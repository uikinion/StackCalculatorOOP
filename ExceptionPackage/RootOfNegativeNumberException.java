package ExceptionPackage;

public class RootOfNegativeNumberException extends ArithmeticException {
    public RootOfNegativeNumberException(double number) {
        super(number + " is negative");
    }
}
