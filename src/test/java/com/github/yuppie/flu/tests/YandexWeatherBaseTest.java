package com.github.yuppie.flu.tests;

import java.io.IOException;

import com.github.yuppie.flu.pages.MainWeatherPage;
import com.github.yuppie.flu.util.Properties;
import com.github.yuppie.flu.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Base class for Selenium tests for Yandex Weather service.
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class YandexWeatherBaseTest {
    /*===========================================[ STATIC VARIABLES ]=============*/
    private static final Logger LOGGER = LoggerFactory.getLogger(YandexWeatherBaseTest.class);
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    private Properties properties = new Properties();
    protected WebDriver driver;
    protected MainWeatherPage mainPage;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @BeforeMethod
    protected void initPageObjects() {
        LOGGER.info("Load main service page");
        driver = WebDriverFactory.getWebDriver();
        driver.get(properties.getUrl());
        mainPage = new MainWeatherPage(driver);
    }

    @AfterSuite
    protected void tearDown() {
        driver.quit();
    }
}
