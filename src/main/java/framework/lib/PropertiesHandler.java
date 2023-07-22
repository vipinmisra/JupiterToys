package framework.lib;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHandler {
    public Properties loadProperties(String path) {
        Properties properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(path);
            properties.load(input);
            return properties;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
