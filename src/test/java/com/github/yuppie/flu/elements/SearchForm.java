package com.github.yuppie.flu.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Represents search city form.
 *
 * @author Kirill Kozlov
 * @since 21.09.2014
 */
public class SearchForm extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(name = "request")
    private TextInput requestInput;

    @FindBy(xpath = "//span[. = 'Найти']/input")
    private Button searchButton;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/
    public void search(String request) {
        requestInput.sendKeys(request);
        searchButton.click();
    }
}
