package com.github.yuppie.flu.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class BriefWeatherData {
    /*===========================================[ STATIC VARIABLES ]=============*/
    public static final Pattern TEMP_INTERVAL_PATTERN = Pattern.compile(
            "([-+]\\d{1,2})…([-+]\\d{1,2})");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private Temperature minTemperature;
    private Temperature maxTemperature;
    private AirPressure airPressure;
    private WindModel wind;
    private Humidity humidity;
    private SunTime sunTime;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public AirPressure getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = new AirPressure(airPressure);
    }

    public void setUnformattedAirPressure(String airPressure) {
        int value = Integer.parseInt(airPressure);
        this.airPressure = new AirPressure(value);
    }

    public WindModel getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = new WindModel(wind);
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = new Humidity(humidity);
    }

    public void setSunTime(String sunTime) {
        this.sunTime = new SunTime(sunTime);
    }

    public SunTime getSunTime() {
        return sunTime;
    }

    public Temperature getMinTemperature() {
        return minTemperature;
    }

    public Temperature getMaxTemperature() {
        return maxTemperature;
    }

    public void setBothTemperatures(String temperature) {
        this.minTemperature = new Temperature(temperature);
        this.maxTemperature = new Temperature(temperature);
    }

    public void setTemperaturesInterval(String tempInterval) {
        Matcher matcher = TEMP_INTERVAL_PATTERN.matcher(tempInterval);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Incorrect format temperature interval: %s", tempInterval));
        }
        this.minTemperature = new Temperature(matcher.group(1));
        this.maxTemperature = new Temperature(matcher.group(2));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder()
            .append("WeatherData:{ ")
            .append("temperature: ")
            .append(minTemperature).append(" - ").append(maxTemperature)
            .append(", air pressure: ").append(airPressure)
            .append(", humidity: ").append(humidity)
            .append("}");
        return sb.toString();
    }
}
