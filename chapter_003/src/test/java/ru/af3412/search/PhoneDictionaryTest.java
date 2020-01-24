package ru.af3412.search;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {

    private final PhoneDictionary phones = new PhoneDictionary();

    @Test
    public void whenFindByName() {
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
    }

    @Test
    public void whenFindTwoByNameReturnTwoValues() {
        phones.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        phones.add(
                new Person("Alex", "Lebedev", "657298", "Petrozavodsk")
        );
        phones.add(
                new Person("John", "Smith", "001236", "Ohio")
        );
        List<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname(), is("Arsentev"));
        assertThat(persons.get(1).getSurname(), is("Lebedev"));
    }

}