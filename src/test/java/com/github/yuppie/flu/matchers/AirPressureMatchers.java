package com.github.yuppie.flu.matchers;

import com.github.yuppie.flu.model.AirPressure;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

import static org.hamcrest.Matchers.*;

/**
 * Hamcrest matchers of AirPressure.
 *
 * @see com.github.yuppie.flu.model.AirPressure
 *
 * @author Kirill Kozlov
 * @since 25.09.2014
 */
public class AirPressureMatchers {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final int MAX_AIR_PRESSURE = 800;
    private static final int MIN_AIR_PRESSURE = 700;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private AirPressureMatchers() {}
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public static Matcher<AirPressure> withinLimits(int min, int max) {
        return new FeatureMatcher<AirPressure, Integer>(
                (both(greaterThan(min)).and(lessThan(max))),
                "air pressure should be", "condition's broken") {
            @Override
            protected Integer featureValueOf(AirPressure airPressure) {
                return airPressure.getValue();
            }
        };
    }

    public static Matcher<AirPressure> withinLogicalAirPressureLimits() {
        return withinLimits(MIN_AIR_PRESSURE, MAX_AIR_PRESSURE);
    }
}
