package Calculator;


import ExceptionPackage.ConfigException;
import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class StackCalculator {
    private final CommandFactory commandFactory;
    private final Context context;
    private PrintStream printStream;
    private static final Logger logger = Logger.getLogger(StackCalculator.class);
    private int commandCount;


    public StackCalculator(String config) throws ConfigException {
        try {
            commandFactory = new CommandFactory(config);
        }
        catch (ConfigException exception) {
            logger.error("config file error: " + exception.getMessage());
            throw exception;
        }
        commandCount = 1;
        context = new Context();
        logger.info("create StackCalculator");
    }

    public void calc(InputStream in, OutputStream out) {
        Scanner scanner = new Scanner(in);
        printStream = new PrintStream(out);
        context.reset();
        logger.info("calculate from " + in.getClass() + " to " + out.getClass());
        while (true) {
            if (!scanner.hasNextLine())
                break;
            String inputString = scanner.nextLine();
            String[] splitString = inputString.split(" ");
            String nameCommand = splitString[0];
            if (nameCommand.equals("EXIT")) {
                logger.info("end calculate");
                break;
            }
            Command command = commandFactory.getCommand(nameCommand, printStream);
            if (command == null) {
                printStream.println("command not found");
                logger.error("line: " + commandCount + "command " + nameCommand + " not found");
                continue;
            }
            tryApplyCommand(command, splitString);
        }
    }

    private void tryApplyCommand(Command command, String[] splitString) {
        try {
            command.apply(context, Arrays.copyOfRange(splitString, 1, splitString.length));
            commandCount++;
            logger.info(command.getName() + ": command apply");
        }
        catch (CalculatorException e) {
            String exceptionName = e.getClass().getName();
            String[] splitName = exceptionName.split("\\.");
            String shortName = splitName[splitName.length - 1];
            printStream.println(shortName + "\n" + e.getMessage());
            logger.error(String.format("line %d: %s %s",
                    commandCount, shortName, e.getMessage()));
        }
    }
}
