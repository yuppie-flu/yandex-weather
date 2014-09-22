package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.model.DayForecast;
import com.github.yuppie.flu.model.DetailedWeatherReportModel;
import com.github.yuppie.flu.model.WindModel;
import com.github.yuppie.flu.pages.MainWeatherPage;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePartial;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.both;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * TODO: add description
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class ContentTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final int MAX_REGISTERED_TEMP = 57;
    private static final int MIN_REGISTERED_TEMP = -92;

    private static final int MAX_AIR_PRESSURE = 800;
    private static final int MIN_AIR_PRESSURE = 700;

    private static final double MAX_REGISTERED_WIND_SPEED_MPS = 113.0;
    private static final int MAX_POSSIBLE_HUMIDITY = 100;

    private static final ReadablePartial MIN_SUNRISE_TIME = new LocalTime(4, 0);
    private static final ReadablePartial MAX_SUNRISE_TIME = new LocalTime(12, 0);

    private static final ReadablePartial MIN_SUNSET_TIME= new LocalTime(14, 0);
    private static final ReadablePartial MAX_SUNSET_TIME = new LocalTime(23, 59);
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private MainWeatherPage mainPage;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @BeforeMethod
    public void initPageObjects() {
        driver.get(baseUrl);
        mainPage = new MainWeatherPage(driver);
    }

    @Test
    public void checkTodayWeatherTest() {
        DetailedWeatherReportModel model = mainPage.getCurrentWeatherReport();

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

        assertThat("Sunrise time limits violation", model.getSunriseTime(),
                (both(greaterThan(MIN_SUNRISE_TIME)).and(lessThan(MAX_SUNRISE_TIME))));

        assertThat("Sunset time limits violation", model.getSunsetTime(),
                (both(greaterThan(MIN_SUNSET_TIME)).and(lessThan(MAX_SUNSET_TIME))));
    }
}
