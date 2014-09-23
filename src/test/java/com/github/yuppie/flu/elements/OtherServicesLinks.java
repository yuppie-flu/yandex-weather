package com.github.yuppie.flu.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Represents set of links to other Yandex services
 *
 * @author Kirill Kozlov
 * @since 24.09.2014
 */
public class OtherServicesLinks extends HtmlElement {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @FindBy(linkText = "Почта")
    private Link mail;
    /*===========================================[ CONSTRUCTORS ]=================*/
    /*===========================================[ CLASS METHODS ]================*/

    public void goToMail() {
        mail.click();
    }
}
