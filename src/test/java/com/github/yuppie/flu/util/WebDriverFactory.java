package com.github.yuppie.flu.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Kirill Kozlov
 * @since 23.09.2014
 */
public class WebDriverFactory {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static WebDriver webDriver;
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public static WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new FirefoxDriver();
        }
        return webDriver;
    }


}
