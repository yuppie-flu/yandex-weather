package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.matchers.AirPressureMatchers;
import com.github.yuppie.flu.matchers.TemperatureMatchers;
import com.github.yuppie.flu.model.BriefWeatherData;
import com.github.yuppie.flu.model.WindModel;
import org.testng.annotations.Test;

import static com.github.yuppie.flu.matchers.SunTimeMatchers.*;
import static com.github.yuppie.flu.matchers.TemperatureMatchers.withinHistoricalRecordsLimits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class CurrentForecastTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final double MAX_REGISTERED_WIND_SPEED_MPS = 113.0;
    private static final int MAX_POSSIBLE_HUMIDITY = 100;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @Test
    public void checkTodayWeatherTest() {
        BriefWeatherData model = mainPage.getCurrentWeatherReport();

        assertThat("Min temperature limits violation", model.getMinTemperature(),
                withinHistoricalRecordsLimits());
        assertThat("Max temperature limits violation", model.getMaxTemperature(),
                withinHistoricalRecordsLimits());

        assertThat("Air pressure limits violation", model.getAirPressure(),
                AirPressureMatchers.withinLogicalAirPressureLimits());

        assertThat("Humidity limits violation", model.getHumidity().getValue(),
                (both(greaterThan(0)).and(lessThanOrEqualTo(MAX_POSSIBLE_HUMIDITY))));

        WindModel windModel = model.getWind();

        assertThat("Wind speed limits violation", windModel.getSpeedMps(),
                (both(greaterThanOrEqualTo(0.0)).and(lessThan(MAX_REGISTERED_WIND_SPEED_MPS))));
        assertThat("Inconsistent wind speed data", windModel.getSpeedKmh(),
                closeTo(windModel.getSpeedMps() * 3600 / 1000, 0.1));

        assertThat("Sunrise time limits violation",
                model.getSunTime(), sunriseTimeWithinLogicalLimits());

        assertThat("Sunset time limits violation",
                model.getSunTime(), sunsetTimeWithinLogicalLimits());
    }
}
