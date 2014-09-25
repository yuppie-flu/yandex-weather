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
    private static final Pattern BOTH_TOGETHER_PATTERN = Pattern.compile(
            "Восход: (\\d{2}):(\\d{2}) Заход: (\\d{2}):(\\d{2})");

    private static final Pattern SUNRISE_PATTERN = Pattern.compile("Восход\\s(\\d{2}):(\\d{2})");
    private static final Pattern SUNSET_PATTERN = Pattern.compile("Заход\\s(\\d{2}):(\\d{2})");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private LocalTime sunriseTime;
    private LocalTime sunsetTime;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public SunTime(String formatString) {
        Matcher matcher = BOTH_TOGETHER_PATTERN.matcher(formatString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of sun time information: %s", formatString));
        }
        this.sunriseTime = createLocalTime(matcher.group(1), matcher.group(2));
        this.sunsetTime = createLocalTime(matcher.group(3), matcher.group(4));
    }

    public SunTime(String sunrise, String sunset) {
        Matcher sunriseMatcher = SUNRISE_PATTERN.matcher(sunrise);
        if (!sunriseMatcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of sunrise time information: %s", sunrise));
        }
        this.sunriseTime = createLocalTime(sunriseMatcher.group(1), sunriseMatcher.group(2));

        Matcher sunsetMatcher = SUNSET_PATTERN.matcher(sunset);
        if (!sunsetMatcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of sunset time information: %s", sunset));
        }
        this.sunsetTime = createLocalTime(sunsetMatcher.group(1), sunsetMatcher.group(2));
    }
    /*===========================================[ CLASS METHODS ]================*/
    private LocalTime createLocalTime(String hours, String min) {
        int sunriseHour = Integer.parseInt(hours);
        int sunriseMin = Integer.parseInt(min);
        return new LocalTime(sunriseHour, sunriseMin);
    }

    public LocalTime getSunriseTime() {
        return sunriseTime;
    }

    public LocalTime getSunsetTime() {
        return sunsetTime;
    }
}
