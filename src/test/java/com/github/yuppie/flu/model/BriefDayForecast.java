package com.github.yuppie.flu.model;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class BriefDayForecast extends DayForecast {
    /*===========================================[ STATIC VARIABLES ]=============*/
    public static final Pattern DATE_PATTERN = Pattern.compile("([0-9]{1,2})( [а-я]*)?");
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private String description;
    private int dayTemp;
    private int nightTemp;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(String dateShort) {
        // FIXME: just ignore month name by now, fix later
        Matcher matcher = DATE_PATTERN.matcher(dateShort);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(
                    String.format("Unexpected format of date info: %s", dateShort));
        }
        // FIXME: month and year doesn't matter for us by now, we are going to check only day
        int year = DateTime.now().getYear();
        int month = DateTime.now().getMonthOfYear();
        int day = Integer.parseInt(matcher.group(1));
        date = new LocalDate(year, month, day);
    }

    public void setDayTemp(String dayTemp) {
        this.dayTemp = Integer.parseInt(dayTemp);
    }

    public void setNightTemp(String nightTemp) {
        this.nightTemp= Integer.parseInt(nightTemp);
    }

    public int getDayTemp() {
        return dayTemp;
    }

    public int getNightTemp() {
        return nightTemp;
    }
}
