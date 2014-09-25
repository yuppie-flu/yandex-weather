package com.github.yuppie.flu.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

/**
 * Search forecast for custom city tests.
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class SearchCityTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @DataProvider()
    public Object[][] cityRequestsProvider() {
        return new Object[][] {
                { "москва", "Москве"},
                { "АНТАЛЬЯ", "Анталье"},
                { "Malmö", "Мальмё"},
        };
    }

    @Test(dataProvider = "cityRequestsProvider")
    public void checkCustomCityForecastTest(String request, String expectedCity) {
        mainPage.searchCity(request);
        String expectedHeader = String.format("Погода в %s", expectedCity);
        assertThat("Unexpected city name in header",
                mainPage.getHeaderWithCityName(), startsWith(expectedHeader));
    }
}
