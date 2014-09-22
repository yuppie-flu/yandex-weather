package com.github.yuppie.flu.elements;

import com.github.yuppie.flu.model.DayForecast;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents forecast scroll with short weather information.
 * Contains the next 9 days.
 *
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public class ForecastShortScroll extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(className = "b-forecast__dayname")
    private List<TextBlock> dayNames;

    @FindBy(className = "b-forecast__day")
    private List<TextBlock> dates;

    @FindBy(className = "b-forecast__desc")
    private List<TextBlock> descriptions;

    @FindBy(className = "b-forecast__tday")
    private List<TextBlock> dayTemp;

    @FindBy(className = "b-forecast__tnight")
    private List<TextBlock> nightTemp;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public int size() {
        return dayNames.size();
    }

    public List<DayForecast> getFullForecast() {
        int size = size();
        List<DayForecast> fullForecast = new ArrayList(size);
        for(int i = 0; i < size; i++) {
            DayForecast dayForecast = new DayForecast();
            dayForecast.setDayName(dayNames.get(i).getText());
            dayForecast.setDate(dates.get(i).getText());
            dayForecast.setDescription(descriptions.get(i).getText());
            dayForecast.setDayTemp(dayTemp.get(i).getText());
            dayForecast.setNightTemp(nightTemp.get(i).getText());
            fullForecast.add(dayForecast);
        }
        return fullForecast;
    }
}
