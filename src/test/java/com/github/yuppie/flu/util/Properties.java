package com.github.yuppie.flu.util;

import ru.yandex.qatools.properties.PropertyLoader;
import ru.yandex.qatools.properties.annotations.Property;
import ru.yandex.qatools.properties.annotations.Resource;

/**
 * @author Kirill Kozlov
 * @since 23.09.2014
 */
@Resource.Classpath("test.properties")
public class Properties {
    /*===========================================[ STATIC VARIABLES ]=============*/
    /*===========================================[ INSTANCE VARIABLES ]===========*/
    @Property("site.url")
    private String mainPageUrl;
    @Property("details.postfix")
    private String detailsPostfix;
    @Property("climate.postfix")
    private String climatePostfix;

    @Property("mail.url")
    private String mailUrl;
    /*===========================================[ CONSTRUCTORS ]=================*/
    public Properties() {
        PropertyLoader.populate(this);
    }
    /*===========================================[ CLASS METHODS ]================*/
    public String getMainPageUrl() {
        return mainPageUrl;
    }

    public String getDetailsPostfix() {
        return detailsPostfix;
    }

    public String getClimatePostfix() {
        return climatePostfix;
    }

    public String getMailUrl() {
        return mailUrl;
    }
}
