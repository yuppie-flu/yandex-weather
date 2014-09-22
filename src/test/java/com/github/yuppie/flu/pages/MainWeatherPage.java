package com.github.yuppie.flu.pages;

import com.github.yuppie.flu.elements.ForecastShortScroll;
import com.github.yuppie.flu.elements.SearchForm;
import com.github.yuppie.flu.elements.TodayWeatherBlock;
import com.github.yuppie.flu.model.DayForecast;
import com.github.yuppie.flu.model.DetailedWeatherReportModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

import java.util.List;

/**
 * Represents main page of Yandex Weather service.
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class MainWeatherPage {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(className = "b-search__table")
    private SearchForm searchForm;

    @FindBy(xpath = "//div[@class = 'b-today']/..")
    private TodayWeatherBlock todayWeatherBlock;

    @FindBy(xpath = "//div[@class = 'b-forecast-scroll']/div")
    private ForecastShortScroll shortScroll;

    /*===========================================[ CONSTRUCTORS ]=================*/
    public MainWeatherPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    /*===========================================[ CLASS METHODS ]================*/
    public void searchCity(String cityRequest) {
        searchForm.search(cityRequest);
    }

    public DetailedWeatherReportModel getCurrentWeatherReport() {
        return todayWeatherBlock.getCurrentWeatherReport();
    }

    public List<DayForecast> getFullForecast() {
        return shortScroll.getFullForecast();
    }

    public int getShortForecastScrollSize() {
        return shortScroll.size();
    }
}
