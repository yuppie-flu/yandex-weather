package com.github.yuppie.flu;

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
 * Base class for all the TestNG-based test classes
 */
public class TestNgTestBase {
    protected static String baseUrl;
    protected WebDriver driver;

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
