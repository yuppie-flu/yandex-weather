package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.model.BriefDayForecast;
import org.joda.time.LocalDate;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Tests for checking content of short forecast scroll.
 *
 * @author Kirill Kozlov
 * @since 23.09.2014
 */
public class BriefForecastTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    public static final int TODAY_SCROLL_SIZE = 10;
    public static final int TOMORROW_SCROLL_SIZE = 9;
    public static final String TODAY_DAYNAME = "сегодня";
    public static final String TOMORROW_DAYNAME = "завтра";
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @Test
    public void checkForecastShortScrollTest() {
        int actualScroolSize = mainPage.getBriefForecastScrollSize();
        assertThat("Unexpected number of days in short forecast scroll",
                actualScroolSize,
                anyOf(equalTo(TODAY_SCROLL_SIZE), equalTo(TOMORROW_SCROLL_SIZE)));

        List<BriefDayForecast> forecast = mainPage.getBriefForecast();
        String actualFirstDayName = forecast.get(0).getDayName();

        if (actualScroolSize == TODAY_SCROLL_SIZE) {
            assertThat("Unexpected name of the first day in the short forecast scroll",
                    actualFirstDayName, equalTo(TODAY_DAYNAME));
        } else {
            assertThat("Unexpected name of the first day in the short forecast scroll",
                    actualFirstDayName, equalTo(TOMORROW_DAYNAME));
        }

        LocalDate startDate = LocalDate.now();
        if (TOMORROW_DAYNAME.equals(actualFirstDayName)) {
           startDate = startDate.plusDays(1);
        }

        for (int i = 0; i < actualScroolSize; i++) {
            BriefDayForecast df = forecast.get(i);

            int actualDay = df.getDate().getDayOfMonth();
            int expectedDay = startDate.plusDays(i).getDayOfMonth();

            assertThat("Incorrect date", actualDay, equalTo(expectedDay));

            assertThat("Day temperature should be greater than night",
                    df.getDayTemp(), greaterThan(df.getNightTemp()));

            // TODO: checking description somehow, for example by weather keywords
            // TODO: add weather icon and check it correlation with description
        }
    }
}
