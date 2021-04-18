package ru.af3412.di;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private final List<String> data = new ArrayList<>();

    public Store() {
    }

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
