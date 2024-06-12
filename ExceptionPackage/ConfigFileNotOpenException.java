package ExceptionPackage;

public class ConfigFileNotOpenException extends ConfigException {
    public ConfigFileNotOpenException(String configFileName) {
        super(configFileName + " not open");
    }
}
