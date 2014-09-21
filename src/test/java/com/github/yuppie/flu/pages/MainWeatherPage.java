package com.github.yuppie.flu.pages;

import com.github.yuppie.flu.elements.SearchForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

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

    /*===========================================[ CONSTRUCTORS ]=================*/
    public MainWeatherPage(WebDriver driver) {
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }

    /*===========================================[ CLASS METHODS ]================*/
    public void search(String request) {
        searchForm.search(request);
    }
}
