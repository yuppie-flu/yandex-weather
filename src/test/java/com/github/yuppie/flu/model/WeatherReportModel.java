package com.github.yuppie.flu.model;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class WeatherReportModel {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private Temperature temperature;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public WeatherReportModel(String temperature) {
        this.temperature = new Temperature(temperature);
    }
    /*===========================================[ CLASS METHODS ]================*/
    public Temperature getTemperature() {
        return temperature;
    }
}
