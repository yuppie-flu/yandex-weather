package com.github.yuppie.flu.matchers;

import com.github.yuppie.flu.model.SunTime;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePartial;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

/**
 * Hamcrest matchers for SunTime.
 *
 * @see com.github.yuppie.flu.model.SunTime
 *
 * @author Kirill Kozlov
 * @since 25.09.2014
 */
public class SunTimeMatchers {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final ReadablePartial MIN_SUNRISE_TIME = new LocalTime(4, 0);
    private static final ReadablePartial MAX_SUNRISE_TIME = new LocalTime(12, 0);

    private static final ReadablePartial MIN_SUNSET_TIME= new LocalTime(14, 0);
    private static final ReadablePartial MAX_SUNSET_TIME = new LocalTime(23, 59);
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private SunTimeMatchers() {}
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public static Matcher<SunTime> sunriseTimeWithinLimits(final ReadablePartial min, final ReadablePartial max) {
        return new FeatureMatcher<SunTime, ReadablePartial>(
                (both(greaterThan(min)).and(lessThan(max))),
                "sunrise time should be", "condition's broken") {
            @Override
            protected ReadablePartial featureValueOf(SunTime suntime) {
                return suntime.getSunriseTime();
            }
        };
    }

    public static Matcher<SunTime> sunriseTimeWithinLogicalLimits() {
        return sunriseTimeWithinLimits(MIN_SUNRISE_TIME, MAX_SUNRISE_TIME);
    }

    public static Matcher<SunTime> sunsetTimeWithinLimits(final ReadablePartial min, final ReadablePartial max) {
        return new FeatureMatcher<SunTime, ReadablePartial>(
                (both(greaterThan(min)).and(lessThan(max))),
                "sunset time - ", "out of limits") {
            @Override
            protected ReadablePartial featureValueOf(SunTime suntime) {
                return suntime.getSunsetTime();
            }
        };
    }

    public static Matcher<SunTime> sunsetTimeWithinLogicalLimits() {
        return sunsetTimeWithinLimits(MIN_SUNSET_TIME, MAX_SUNSET_TIME);
    }
}
