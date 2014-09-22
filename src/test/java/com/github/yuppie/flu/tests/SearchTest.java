package com.github.yuppie.flu.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

/**
 * Search forecast for custom city tests.
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class SearchTest extends YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @Test
    public void checkCustomCityForecastTest() {
        mainPage.searchCity("кострома");
        WebElement element = driver.findElement(By.className("b-navigation-city"));
        assertThat(element.getText(), startsWith("Погода в Костром"));
    }
}
