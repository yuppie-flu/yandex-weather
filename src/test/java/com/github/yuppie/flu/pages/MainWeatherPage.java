package com.github.yuppie.flu.pages;

import com.github.yuppie.flu.elements.*;
import com.github.yuppie.flu.model.BriefDayForecast;
import com.github.yuppie.flu.model.BriefWeatherData;
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
public class MainWeatherPage extends YandexPage {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private WebDriver driver;

    @FindBy(className = "b-search__table")
    private SearchForm searchForm;

    @FindBy(className = "l-head__c")
    private OtherServicesLinks otherServicesLinks;

    @FindBy(xpath = "//div[@class = 'b-today']/..")
    private TodayWeatherBlock todayWeatherBlock;

    @FindBy(xpath = "//div[@class = 'b-forecast-scroll']/div")
    private ForecastBriefScroll briefScroll;

    @FindBy(xpath = "//div[@class = 'b-widget-current-weather']/following-sibling::*[1]/self::div")
    private ForecastTypeSelector forecastTypeSelector;

    /*===========================================[ CONSTRUCTORS ]=================*/
    public MainWeatherPage(WebDriver driver) {
        super(driver.getCurrentUrl());
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    /*===========================================[ CLASS METHODS ]================*/
    public void searchCity(String cityRequest) {
        searchForm.search(cityRequest);
    }

    public BriefWeatherData getCurrentWeatherReport() {
        return todayWeatherBlock.getCurrentWeatherReport();
    }

    public List<BriefDayForecast> getBriefForecast() {
        return briefScroll.getForecast();
    }

    public int getBriefForecastScrollSize() {
        return briefScroll.size();
    }

    public DetailedForecastPage getDetaliedForecat() {
        forecastTypeSelector.selectDetailedReport(driver);
        return new DetailedForecastPage(driver);
    }

    public ClimatePage getClimate() {
        forecastTypeSelector.selectClimateReport(driver);
        return new ClimatePage(driver);
    }

    public YandexMailPage goToMail() {
        otherServicesLinks.goToMail();
        return new YandexMailPage(driver);
    }
}
