package com.testautomation.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties prop = new Properties();

    public ConfigReader() {
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Unable to load config.properties", e);
        }
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}
