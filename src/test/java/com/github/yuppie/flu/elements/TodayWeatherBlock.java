package com.github.yuppie.flu.elements;

import com.github.yuppie.flu.model.BriefWeatherData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

/**
 * Represents current weather report block.
 *
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class TodayWeatherBlock extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(className = "b-today")
    private TextBlock now;

    @FindBy(className="b-thermometer__now")
    private TextBlock temperature;

    @FindBy(xpath = "//span[starts-with(text(), 'Давление: ')]/..")
    private TextBlock airPressure;

    @FindBy(xpath = "//span[starts-with(text(), 'Ветер: ')]/..")
    private TextBlock wind;

    @FindBy(xpath = "//span[starts-with(text(), 'Влажность: ')]/..")
    private TextBlock humidity;

    @FindBy(xpath = "//span[starts-with(text(), 'Восход: ')]/..")
    private TextBlock sunTime;

    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public BriefWeatherData getCurrentWeatherReport() {
        BriefWeatherData model = new BriefWeatherData();
        model.setBothTemperatures(temperature.getText());
        model.setAirPressure(airPressure.getText());
        model.setWind(wind.getText());
        model.setHumidity(humidity.getText());
        model.setSunTime(sunTime.getText());
        return model;
    }
}
