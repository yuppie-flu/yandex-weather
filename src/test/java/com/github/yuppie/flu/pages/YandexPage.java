package com.github.yuppie.flu.pages;

/**
 * Represents web page.
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class YandexPage {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private String url;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public YandexPage(String url) {
        this.url = url;
    }
    /*===========================================[ CLASS METHODS ]================*/
    public String getUrl() {
        return url;
    }
}
