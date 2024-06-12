package ExceptionPackage;

public class ConfigFileCommandNotFoundException extends ConfigException {
    public ConfigFileCommandNotFoundException(String commandName, int line) {
        super(String.format("line %d: %s - not found class for this command",
                line, commandName));
    }
}
