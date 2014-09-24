package com.github.yuppie.flu.pages;

import com.github.yuppie.flu.elements.ForecastDetailedScroll;
import com.github.yuppie.flu.model.DetailedDayForecast;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.util.List;

/**
 * TODO: add description
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class DetailedForecastPage extends YandexPage {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(className = "b-forecast-detailed")
    private ForecastDetailedScroll detailedScroll;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public DetailedForecastPage(WebDriver driver) {
        super(driver.getCurrentUrl());
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }
    /*===========================================[ CLASS METHODS ]================*/
    public int getDetailedForecastScrollSize() {
        return detailedScroll.size();
    }

    public List<DetailedDayForecast> getDetailedForecast() {
        return detailedScroll.getForecast();
    }
}
