package com.github.yuppie.flu.elements;

import com.github.yuppie.flu.model.BriefWeatherData;
import com.github.yuppie.flu.model.DayPart;
import com.github.yuppie.flu.model.DetailedDayForecast;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;
import java.util.List;

import static com.github.yuppie.flu.model.DayPart.*;

/**
 * Represents detailed forecast scroll.
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class ForecastDetailedScroll extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(xpath = "//tr[@class = 'b-forecast-detailed__line']/*[1]/div")
    private List<TextBlock> dayNames;

    @FindBy(className = "b-forecast-detailed__date")
    private List<TextBlock> dayAsNumbers;

    @FindBy(className = "b-forecast-detailed__month")
    private List<TextBlock> months;

    @FindBy(xpath = "//td[contains(@class, 'b-forecast-detailed__item_type_rise')]")
    private List<TextBlock> sunriseTimes;

    @FindBy(xpath = "//td[contains(@class, 'b-forecast-detailed__item_type_sunset')]")
    private List<TextBlock> sunsetTimes;

    @FindBy(xpath = "//div[@class = 'b-forecast-detailed__daypart' and text() = 'утром']/following-sibling::div[1]")
    private List<TextBlock> morningTemps;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public int size() {
        return dayNames.size();
    }

    public List<DetailedDayForecast> getForecast() {
        int size = size();
        List<DetailedDayForecast> forecast = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            DetailedDayForecast dayForecast = new DetailedDayForecast();
            dayForecast.setDayName(dayNames.get(i).getText());
            dayForecast.setDate(dayAsNumbers.get(i).getText(), months.get(i).getText());
            dayForecast.setSunTime(sunriseTimes.get(i).getText(), sunsetTimes.get(i).getText());

            BriefWeatherData morningWeather = new BriefWeatherData();
            morningWeather.setTemperaturesInterval(morningTemps.get(i).getText());
            dayForecast.setWeather(MORNING, morningWeather);

            forecast.add(dayForecast);
        }
        return forecast;
    }
}
