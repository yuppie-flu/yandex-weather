package com.github.yuppie.flu.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Radio;

import java.util.List;

/**
 * Represents buttons to select different forecast types.
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class ForecastTypeSelector extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(xpath = "//input[@value = 'detailed']")
    private WebElement detailedSelector;

    @FindBy(xpath = "//input[@value = 'climate']")
    private WebElement climateSelector;

    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public void selectDetailedReport(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", detailedSelector);
    }

    public void selectClimateReport(WebDriver driver) {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", climateSelector);
    }
}
