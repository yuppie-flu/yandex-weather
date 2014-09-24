package com.github.yuppie.flu.model;

import org.joda.time.LocalTime;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class BriefWeatherReportModel extends WeatherReportModel {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private AirPressure airPressure;
    private WindModel wind;
    private Humidity humidity;
    private SunTime sunTime;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public BriefWeatherReportModel(String temperature) {
        super(temperature);
    }
    /*===========================================[ CLASS METHODS ]================*/
    public AirPressure getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(String airPressure) {
        this.airPressure = new AirPressure(airPressure);
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
}
