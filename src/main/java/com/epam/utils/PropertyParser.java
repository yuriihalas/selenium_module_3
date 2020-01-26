package com.epam.utils;

import java.util.HashMap;
import java.util.Objects;

public class PropertyParser {
    private static HashMap<String, String> defaultProperties;

    static {
        initializeDefaultProperties();
    }

    private PropertyParser() {
    }

    public static String getPropertyOrDefault(String key) {
        String valueProperty = System.getProperty(key);
        return Objects.isNull(valueProperty) || valueProperty.isEmpty() ? defaultProperties.get(key) : valueProperty;
    }


    private static void initializeDefaultProperties() {
        defaultProperties = new HashMap<String, String>() {{
            put(PropertyKey.NICK.getName(), "Yankee");
            put(PropertyKey.EMAIL.getName(), "galasayra123213@gmail.com");
            put(PropertyKey.PASS.getName(), "12312390op");
            put(PropertyKey.TITLE.getName(), "Default title:)");
            put(PropertyKey.LOCATION.getName(), "Lviv");
            put(PropertyKey.ABOUT.getName(), "I like java and my job, that's all))");
        }};
    }
}
