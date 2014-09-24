package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.model.BriefWeatherReportModel;
import com.github.yuppie.flu.model.WindModel;
import org.testng.annotations.Test;

import static com.github.yuppie.flu.matchers.SunTimeMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class CurrentForecastTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final int MAX_REGISTERED_TEMP = 57;
    private static final int MIN_REGISTERED_TEMP = -92;

    private static final int MAX_AIR_PRESSURE = 800;
    private static final int MIN_AIR_PRESSURE = 700;

    private static final double MAX_REGISTERED_WIND_SPEED_MPS = 113.0;
    private static final int MAX_POSSIBLE_HUMIDITY = 100;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @Test
    public void checkTodayWeatherTest() {
        BriefWeatherReportModel model = mainPage.getCurrentWeatherReport();

        assertThat("Temperature limits violation", model.getTemperature().getValue(),
                (both(greaterThan(MIN_REGISTERED_TEMP)).and(lessThan(MAX_REGISTERED_TEMP))));

        assertThat("Air pressure limits violation", model.getAirPressure().getValue(),
                (both(greaterThan(MIN_AIR_PRESSURE)).and(lessThan(MAX_AIR_PRESSURE))));

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
