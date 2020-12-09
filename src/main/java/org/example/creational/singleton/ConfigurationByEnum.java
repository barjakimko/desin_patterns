package org.example.creational.singleton;

public enum ConfigurationByEnum {

    CONFIGURATION_BY_ENUM("This could be some description");

    private String description;

    ConfigurationByEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
