package com.github.yuppie.flu.tests;

import com.github.yuppie.flu.pages.MainWeatherPage;
import com.github.yuppie.flu.util.Properties;
import com.github.yuppie.flu.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

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
    protected Properties properties = new Properties();
    protected WebDriver driver;
    protected MainWeatherPage mainPage;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    @BeforeMethod
    protected void initPageObjects() {
        String initialUrl = properties.getMainPageUrl();
        LOGGER.info("Load initial page for the test: {}", initialUrl);
        driver = WebDriverFactory.getWebDriver();
        driver.get(initialUrl);
        mainPage = new MainWeatherPage(driver);
    }

    @AfterSuite
    protected void tearDown() {
        driver.quit();
    }
}
