package Calculator;

import ExceptionPackage.ConfigException;
import ExceptionPackage.ConfigFileClassConstructorException;
import ExceptionPackage.ConfigFileCommandNotFoundException;
import ExceptionPackage.ConfigFileNotOpenException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Scanner;

public class CommandFactory {
    HashMap<String, Command> stringToClassMap = new HashMap<>();
    CommandFactory(String configFileName) throws ConfigException{
        String name = null;
        String className = null;
        int line = 1;
        try (Scanner scanner = new Scanner(new FileReader(configFileName))) {
            String inputString = scanner.nextLine();
            while (inputString.length() != 0) {
                String[] pair = inputString.split(" ");
                if (pair.length != 2) {
                    throw new ConfigException("invalid config file format");
                }
                name = pair[0];
                className = pair[1];
                Class<?> commandClass = Class.forName("CalculatorCommand." + className);
                Command command = (Command) commandClass.getDeclaredConstructor(String.class).newInstance(name);
                stringToClassMap.put(name, command);
                if (!scanner.hasNextLine())
                    break;
                inputString = scanner.nextLine();
                line++;
            }
        }
        catch (IOException e) {
            throw new ConfigFileNotOpenException(configFileName);
        }
        catch (ClassNotFoundException e) {
            throw new ConfigFileCommandNotFoundException(name, line);
        }
        catch (NoSuchMethodException e) {
            throw new ConfigFileClassConstructorException(className, line);
        }
        catch (Exception exception) {
            throw new ConfigException(exception.getMessage());
        }
    }


    public Command getCommand(String nameCommand, PrintStream printStream) {
        Command command = stringToClassMap.get(nameCommand);
        command.setPrintStream(printStream);
        return command;
    }
}
