package com.github.yuppie.flu.matchers;

import com.github.yuppie.flu.model.Temperature;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

/**
 * Hamcrest matchers for Temperature
 *
 * @see com.github.yuppie.flu.model.Temperature
 *
 * @author Kirill Kozlov
 * @since 25.09.2014
 */
public class TemperatureMatchers {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final int MAX_REGISTERED_TEMP = 57;
    private static final int MIN_REGISTERED_TEMP = -92;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private TemperatureMatchers() {}
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public static Matcher<Temperature> withinLimits(int min, int max) {
        return new FeatureMatcher<Temperature, Integer>(
                (both(greaterThan(min)).and(lessThan(max))),
                "temperature should be", "condition's broken") {
            @Override
            protected Integer featureValueOf(Temperature temp) {
                return temp.getValue();
            }
        };
    }

    public static Matcher<Temperature> withinHistoricalRecordsLimits() {
        return withinLimits(MIN_REGISTERED_TEMP, MAX_REGISTERED_TEMP);
    }
}
