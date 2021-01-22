package com.example.quickcook.data.model;

public enum Type {

    MAIN_COURSE("main course"),
    BREAKFAST("breakfast"),
    DINNER("dinner"),
    LUNCH("lunch"),
    DRINK("drink"),
    SALAD("salad");

    private String type;

    private Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
