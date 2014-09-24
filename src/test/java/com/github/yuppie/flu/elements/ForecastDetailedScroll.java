package com.github.yuppie.flu.elements;

import com.github.yuppie.flu.model.BriefDayForecast;
import com.github.yuppie.flu.model.DetailedDayForecast;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;
import java.util.List;

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
            forecast.add(dayForecast);
        }
        return forecast;
    }
}
