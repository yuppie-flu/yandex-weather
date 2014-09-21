package com.github.yuppie.flu.pages;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by tribal on 9/21/14.
 */
@Name("Search form")
public class SearchForm extends HtmlElement {

    @Name("Search request input")
    @FindBy(name = "request")
    private TextInput requestInput;

    public void search(String request) {
        requestInput.sendKeys(request);
        submit();
    }
}
