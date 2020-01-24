package ru.af3412.search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {

    private final List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        final List<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (person.getAddress().contains(key) || person.getSurname().contains(key) || person.getName().contains(key) || person.getPhone().contains(key)) {
                result.add(person);
            }
        }
        return result;
    }
}
