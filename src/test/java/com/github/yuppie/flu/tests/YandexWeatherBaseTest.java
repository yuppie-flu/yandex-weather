package com.github.yuppie.flu.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Capabilities;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.github.yuppie.flu.util.PropertyLoader;

/**
 * Base class for Selenium tests for Yandex Weather service.
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    protected static String baseUrl;
    protected WebDriver driver;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @BeforeSuite
    public void initWebDriverFactory() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
