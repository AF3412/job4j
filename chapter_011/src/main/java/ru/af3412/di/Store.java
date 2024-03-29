package ru.af3412.di;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
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
