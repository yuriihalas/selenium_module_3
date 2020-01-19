package com.epam.utils;

public enum PropertyKey {
    NICK,
    EMAIL,
    PASS,
    TITLE,
    LOCATION,
    ABOUT;

    public String getName() {
        return name().toLowerCase();
    }
}
