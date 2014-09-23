package com.github.yuppie.flu.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;

/**
 * TODO: add description
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class DetailedForecastPage extends YandexPage {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    public DetailedForecastPage(WebDriver driver) {
        super(driver.getCurrentUrl());
        PageFactory.initElements(new HtmlElementDecorator(driver), this);
    }
    /*===========================================[ CLASS METHODS ]================*/
}
