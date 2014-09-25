package com.github.yuppie.flu.matchers;

import com.github.yuppie.flu.model.Humidity;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

/**
 * Hamcrest matchers for Humidity.
 *
 * @see com.github.yuppie.flu.model.Humidity
 *
 * @author Kirill Kozlov
 * @since 25.09.2014
 */
public class HumidityMatchers {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final int MIN_POSSIBLE_HUMIDITY = 0;
    private static final int MAX_POSSIBLE_HUMIDITY = 100;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    private HumidityMatchers() {}
    /*===========================================[ CLASS METHODS ]================*/
    public static Matcher<Humidity> withinLimits(int min, int max) {
        return new FeatureMatcher<Humidity, Integer>(
                (both(greaterThan(min)).and(lessThan(max))),
                "humidity should be", "condition's broken") {
            @Override
            protected Integer featureValueOf(Humidity humidity) {
                return humidity.getValue();
            }
        };
    }

    public static Matcher<Humidity> withinLogicalHumidityLimits() {
        return withinLimits(MIN_POSSIBLE_HUMIDITY, MAX_POSSIBLE_HUMIDITY);
    }
}
