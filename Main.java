import Calculator.StackCalculator;
import ExceptionPackage.ConfigException;

public class Main {
    public static void main(String[] args) {
        StackCalculator calculator = null;
        try {
            calculator = new StackCalculator("commandConfig.txt");
        } catch (ConfigException e) {
            return;
        }
        calculator.calc(System.in, System.out);
    }
}