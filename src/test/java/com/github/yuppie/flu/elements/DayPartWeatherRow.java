package com.github.yuppie.flu.elements;

import com.github.yuppie.flu.model.BriefWeatherData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Represents row of detailed forecast scroll with weather data of a day part.
 *
 * @author Kirill Kozlov
 * @since 25.09.2014
 */
public class DayPartWeatherRow extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(className = "b-forecast-detailed__temp")
    private TextBlock temp;

    @FindBy(css = "td.b-forecast-detailed__item_type_pressure")
    private TextBlock airPressure;

    @FindBy(css = "td.b-forecast-detailed__item_type_humidity")
    private TextBlock humidity;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public BriefWeatherData getWeatherData() {
        BriefWeatherData weatherData = new BriefWeatherData();
        weatherData.setTemperaturesInterval(temp.getText());
        weatherData.setUnformattedAirPressure(airPressure.getText());
        weatherData.setHumidity(humidity.getText());
        return weatherData;
    }
}
