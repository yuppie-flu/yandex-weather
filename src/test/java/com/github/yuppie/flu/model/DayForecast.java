package com.github.yuppie.flu.model;

import org.joda.time.LocalDate;

/**
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class DayForecast {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private String dayName;
    protected LocalDate date;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public LocalDate getDate() {
        return date;
    }
}
