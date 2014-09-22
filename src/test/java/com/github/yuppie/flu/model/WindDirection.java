package com.github.yuppie.flu.model;

/**
 * @author Kirill Kozlov
 * @since 22.09.2014
 */
public enum WindDirection {
    N("северный"), E("восточный"), S("южный"), W("западный"),
    SW("юго-западный"), SE("юго-восточный"), NE("северо-восточный"), NW("северо-западный");

    private String description;

    private WindDirection(String description) {
        this.description = description;
    }

    public static WindDirection getByDescription(String description) {
        for (WindDirection wd: values()) {
            if (wd.description.equals(description)) {
                return wd;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown wind direction: %s", description));
    }

    @Override
    public String toString() {
        return description;
    }
}
