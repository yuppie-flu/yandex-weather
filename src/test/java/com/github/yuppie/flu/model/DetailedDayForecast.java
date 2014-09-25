package com.github.yuppie.flu.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class DetailedDayForecast extends DayForecast {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Map<String, Integer> RUSSIAN_MONTH_NAMES;
    static {
        RUSSIAN_MONTH_NAMES = new HashMap<>();
        RUSSIAN_MONTH_NAMES.put("января",   1);
        RUSSIAN_MONTH_NAMES.put("февраля",  2);
        RUSSIAN_MONTH_NAMES.put("марта",    3);
        RUSSIAN_MONTH_NAMES.put("апреля",   4);
        RUSSIAN_MONTH_NAMES.put("мая",      5);
        RUSSIAN_MONTH_NAMES.put("июня",     6);
        RUSSIAN_MONTH_NAMES.put("июля",     7);
        RUSSIAN_MONTH_NAMES.put("августа",  8);
        RUSSIAN_MONTH_NAMES.put("сентября", 9);
        RUSSIAN_MONTH_NAMES.put("октября", 10);
        RUSSIAN_MONTH_NAMES.put("ноября",  11);
        RUSSIAN_MONTH_NAMES.put("декабря", 12);
    }
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private SunTime sunTime;
    private Map<DayPart, BriefWeatherData> dayPartWeather = new EnumMap(DayPart.class);
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public void setDate(String dayString, String monthString) {
        int currentYear = DateTime.now().getYear();
        int currentMonth = DateTime.now().getMonthOfYear();
        int year = currentYear;
        if (!RUSSIAN_MONTH_NAMES.containsKey(monthString)) {
            throw new IllegalArgumentException(String.format("Unknown month name: %s", monthString));
        }
        int month = RUSSIAN_MONTH_NAMES.get(monthString);
        if (currentMonth == 12 && month == 1) {
           year++;
        }

        int day = Integer.parseInt(dayString);
        date = new LocalDate(year, month, day);
    }

    public void setSunTime(String sunrise, String sunset) {
        this.sunTime = new SunTime(sunrise, sunset);
    }

    public SunTime getSunTime() {
        return sunTime;
    }

    public Map<DayPart, BriefWeatherData> getDayPartWeather() {
        return dayPartWeather;
    }

    public void setWeather(DayPart dayPart, BriefWeatherData weather) {
        dayPartWeather.put(dayPart, weather);
    }
}
