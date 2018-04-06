package by.epam.library.model.command.util;

import java.util.ResourceBundle;

public class ConfigurationManager {

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
