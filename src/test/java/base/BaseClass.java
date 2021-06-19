package base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    private static  String browser;

    static {
        //Read properties file
        Properties properties = readPropertiesFile();
        browser  = properties.getProperty("browserName");
    }

    private static Properties readPropertiesFile() {
        BufferedReader reader;

        Properties properties = null;
        String propertyFilePath = "src/test/resources/configuration.properties";


        try {
            FileReader fileReader = new FileReader(propertyFilePath);
            reader = new BufferedReader(fileReader);
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }

        return properties;
    }

    public static String getBrowser() {
        return browser;
    }
}
