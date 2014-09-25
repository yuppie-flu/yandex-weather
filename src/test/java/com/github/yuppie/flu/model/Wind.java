package com.github.yuppie.flu.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class Wind {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Pattern PATTERN = Pattern.compile(
            "Ветер: ([-а-я]+), (\\d{1,3}\\.\\d) м/с \\((\\d{1,3}\\.\\d) км/ч\\)");

    private static final Pattern WIND_DIRECTION_PATTERN = Pattern.compile(
            "Ветер: ([-а-я]+)");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private WindDirection direction;
    private double speedMps;
    private double speedKmh;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public Wind(String formatString) {
        Matcher matcher = PATTERN.matcher(formatString);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of wind information: %s", formatString));
        }
        this.direction = WindDirection.getByDescription(matcher.group(1));
        this.speedMps = Double.valueOf(matcher.group(2));
        this.speedKmh = Double.valueOf(matcher.group(3));
    }

    public Wind(String direction, String speedMps) {
        Matcher matcher = WIND_DIRECTION_PATTERN.matcher(direction);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format of wind direction information: %s", direction));
        }
        this.direction = WindDirection.getByDescription(matcher.group(1));
        this.speedMps = Double.valueOf(speedMps);
        this.speedKmh = this.speedMps * 3600 / 1000;
    }
    /*===========================================[ CLASS METHODS ]================*/
    public double getSpeedMps() {
        return speedMps;
    }

    public double getSpeedKmh() {
        return speedKmh;
    }

    public WindDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return String.format("%s, %.1f м/с", direction, speedMps);
    }
}
