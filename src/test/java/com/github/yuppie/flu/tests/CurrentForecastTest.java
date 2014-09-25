package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.matchers.HumidityMatchers;
import com.github.yuppie.flu.model.BriefWeatherData;
import com.github.yuppie.flu.model.Wind;
import org.testng.annotations.Test;

import static com.github.yuppie.flu.matchers.AirPressureMatchers.withinLogicalAirPressureLimits;
import static com.github.yuppie.flu.matchers.SunTimeMatchers.*;
import static com.github.yuppie.flu.matchers.TemperatureMatchers.withinHistoricalRecordsLimits;
import static com.github.yuppie.flu.matchers.WindMatchers.withinHistoricalWindLimits;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class CurrentForecastTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
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
                withinLogicalAirPressureLimits());

        assertThat("Humidity limits violation", model.getHumidity(),
                HumidityMatchers.withinLogicalHumidityLimits());

        Wind wind = model.getWind();

        assertThat("Wind speed limits violation", wind, withinHistoricalWindLimits());
        assertThat("Inconsistent wind speed data", wind.getSpeedKmh(),
                closeTo(wind.getSpeedMps() * 3600 / 1000, 0.1));

        assertThat("Sunrise time limits violation",
                model.getSunTime(), sunriseTimeWithinLogicalLimits());

        assertThat("Sunset time limits violation",
                model.getSunTime(), sunsetTimeWithinLogicalLimits());
    }
}
