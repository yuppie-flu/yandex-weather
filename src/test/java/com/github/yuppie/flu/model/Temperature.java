package com.github.yuppie.flu.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class Temperature {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Pattern PATTERN = Pattern.compile("([-+]\\d{1,2})( °C)?");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private int value;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public Temperature(String formatString) {
        Matcher matcher = PATTERN.matcher(formatString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of temperature information: %s", formatString));
        }
        this.value = Integer.parseInt(matcher.group(1));
    }
    /*===========================================[ CLASS METHODS ]================*/
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
