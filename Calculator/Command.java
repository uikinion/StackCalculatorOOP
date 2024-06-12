package Calculator;

import java.io.PrintStream;

public abstract class Command {
    private final String name;
    protected PrintStream printStream;

    public Command(String name) {
        this.name = name;
    }

    public abstract void apply(Context context, String[] args) throws CalculatorException;

    public String getName() {
        return name;
    }

    public void setPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }
}
