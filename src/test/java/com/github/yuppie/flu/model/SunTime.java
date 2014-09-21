package com.github.yuppie.flu.model;

import org.joda.time.LocalTime;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class SunTime {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Pattern PATTERN = Pattern.compile(
            "Восход: (\\d{2}):(\\d{2}) Заход: (\\d{2}):(\\d{2})");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private LocalTime sunriseTime;
    private LocalTime sunsetTime;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public SunTime(String formatString) {
        Matcher matcher = PATTERN.matcher(formatString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of sun time information: %s", formatString));
        }
        int sunriseHour = Integer.parseInt(matcher.group(1));
        int sunriseMin = Integer.parseInt(matcher.group(2));
        this.sunriseTime = new LocalTime(sunriseHour, sunriseMin);

        int sunsetHour = Integer.parseInt(matcher.group(3));
        int sunsetMin = Integer.parseInt(matcher.group(4));
        this.sunsetTime = new LocalTime(sunsetHour, sunsetMin);
    }
    /*===========================================[ CLASS METHODS ]================*/
    public LocalTime getSunriseTime() {
        return sunriseTime;
    }

    public LocalTime getSunsetTime() {
        return sunsetTime;
    }
}
