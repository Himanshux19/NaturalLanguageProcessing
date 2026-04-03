package com.nlp.NLP.model;

public enum Type {
    PERSON("Person"),
    CITY("City"),
    STATE_OR_PROVINCE("State_Or_Province"),
    EMAIL("Email"),
    TITLE("Title"),
    COUNTRY("Country");

    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getName() {
        return type;
    }
}
