package com.github.yuppie.flu.pages;

import org.openqa.selenium.WebDriver;

/**
 * Represents main page of Yandex mail service.
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class YandexMailPage extends YandexPage {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    public YandexMailPage(WebDriver driver) {
        super(driver.getCurrentUrl());
    }
    /*===========================================[ CLASS METHODS ]================*/
}
