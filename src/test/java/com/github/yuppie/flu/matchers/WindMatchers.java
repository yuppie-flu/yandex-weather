package com.github.yuppie.flu.matchers;

import com.github.yuppie.flu.model.Wind;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

/**
 * Hamcrest matchers for Wind.
 *
 * @see com.github.yuppie.flu.model.Wind
 *
 * @author Kirill Kozlov
 * @since 25.09.2014
 */
public class WindMatchers {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final double MAX_REGISTERED_WIND_SPEED_MPS = 113.0;
    private static final double MIN_WIND_SPEED_MPS = .0;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private WindMatchers() {}
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public static Matcher<Wind> withinLimits(double min, double max) {
        return new FeatureMatcher<Wind, Double>(
                (both(greaterThan(min)).and(lessThan(max))),
                "wind should be", "condition's broken") {
            @Override
            protected Double featureValueOf(Wind wind) {
                return wind.getSpeedMps();
            }
        };
    }

    public static Matcher<Wind> withinHistoricalWindLimits() {
        return withinLimits(MIN_WIND_SPEED_MPS, MAX_REGISTERED_WIND_SPEED_MPS);
    }
}
