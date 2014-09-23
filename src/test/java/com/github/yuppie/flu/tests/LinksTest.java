package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.pages.YandexPage;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Tests for checking links and buttons which lead to other pages.
 * TODO: check other external services links (Maps, Market, Search, etc)
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class LinksTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @Test
    public void checkDetailedForecastButtonWorksTest() {
        YandexPage detailedForecastPage = mainPage.getDetaliedForecat();
        String commonUrlPrefix = properties.getMainPageUrl();
        String detailsPostfix = properties.getDetailsPostfix();
        assertThat("Button doesn't lead us to desired page",
                detailedForecastPage.getUrl(),
                (both(startsWith(commonUrlPrefix))).and(endsWith(detailsPostfix)));
    }

    @Test
    public void checkClimateButtonWorksTest() {
        YandexPage climatePage = mainPage.getClimate();
        String commonUrlPrefix = properties.getMainPageUrl();
        String climatePostfix = properties.getClimatePostfix();
        assertThat("Button doesn't lead us to desired page",
                climatePage.getUrl(),
                (both(startsWith(commonUrlPrefix))).and(endsWith(climatePostfix)));
    }

    @Test
    public void checkMailLinkWorksTest() {
        YandexPage mailPage = mainPage.goToMail();
        assertThat("Link doesn't lead us to desired page",
                mailPage.getUrl(), equalTo(properties.getMailUrl()));
    }
}
