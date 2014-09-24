package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.model.BriefDayForecast;
import com.github.yuppie.flu.model.DetailedDayForecast;
import com.github.yuppie.flu.pages.DetailedForecastPage;
import com.github.yuppie.flu.util.WebDriverFactory;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;

/**
 * TODO: add description
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class DetailedForecastTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Logger LOGGER = LoggerFactory.getLogger(DetailedForecastTest.class);

    public static final int TODAY_SCROLL_SIZE = 10;
    public static final int TOMORROW_SCROLL_SIZE = 9;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private DetailedForecastPage detailedForecastPage;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @BeforeMethod
    protected void initPageObjects() {
        String initialUrl = String.format("%s%s",
                properties.getMainPageUrl(), properties.getDetailsPostfix());
        LOGGER.info("Load initial page for the test: {}", initialUrl);
        driver = WebDriverFactory.getWebDriver();
        driver.get(initialUrl);
        detailedForecastPage = new DetailedForecastPage(driver);
    }

    @Test
    public void checkForecastShortScrollTest() {
        int actualScroolSize = detailedForecastPage.getDetailedForecastScrollSize();
        assertThat("Unexpected number of days in short forecast scroll",
                actualScroolSize,
                anyOf(equalTo(TODAY_SCROLL_SIZE), equalTo(TOMORROW_SCROLL_SIZE)));

        List<DetailedDayForecast> forecast = detailedForecastPage.getDetailedForecast();
        LocalDate startDate = LocalDate.now();

        for (int i = 0; i < actualScroolSize; i++) {
            DetailedDayForecast df = forecast.get(i);

            LocalDate actualDate = df.getDate();
            LocalDate expectedDate = startDate.plusDays(i);

            assertThat("Incorrect date", actualDate, equalTo(expectedDate));
        }
    }
}
