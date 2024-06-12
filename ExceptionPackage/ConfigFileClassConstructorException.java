package ExceptionPackage;

public class ConfigFileClassConstructorException extends ConfigException{
    public ConfigFileClassConstructorException(String className, int line) {
        super(String.format("line %d: %s class constructor Command(String) not found",
                line, className));
    }
}
