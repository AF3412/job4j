package ru.af3412.testwork;

public class Holder {

    private final String key;
    private final String value;

    Holder(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
