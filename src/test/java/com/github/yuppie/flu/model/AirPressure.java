package com.github.yuppie.flu.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class AirPressure {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Pattern PATTERN = Pattern.compile("Давление: (\\d{2,3}) мм рт\\. ст\\.");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private int value;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public AirPressure(String formatString) {
        Matcher matcher = PATTERN.matcher(formatString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of air pressure information: %s", formatString));
        }
        this.value = Integer.parseInt(matcher.group(1));
    }

    public AirPressure(int value) {
        this.value = value;
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
