package ru.af3412.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    private final Profile firstClient = new Profile(new Address("Moscow", "Tverskaya", 1, 5));
    private final Profile secondClient = new Profile(new Address("Kazan", "Pravo-Bulachnaya", 5, 25));
    private final Profile thirdClient = new Profile(new Address("Ufa", "Pushkina", 7, 7));
    private final Profile fourClient = new Profile(new Address("Ufa", "Pushkina", 7, 7));
    private final Profile fiveClient = new Profile(new Address("Moscow", "Tverskaya", 1, 5));


    /*
    В туристической компании появилась задача составить список адресов клиентов.
    */
    @Test
    public void whenCollectClientsAddressThenReturnListAddress() {
        final List<Profile> clientProfiles = new ArrayList<>() { {
            add(firstClient);
            add(secondClient);
            add(thirdClient);
        } };
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(clientProfiles);

        List<Address> expected = new ArrayList<>() { {
            add(new Address("Moscow", "Tverskaya", 1, 5));
            add(new Address("Kazan", "Pravo-Bulachnaya", 5, 25));
            add(new Address("Ufa", "Pushkina", 7, 7));
        } };

        assertThat(result, is(expected));

    }

    /*
    1. Нужно в списке оставить только уникальные элементы.
    2. Для быстрого поиска по адресам список нужно было отсортировать.
    */
    @Test
    public void whenCollectClientsAddressThenReturnDistinctSortedListAddress() {
        final List<Profile> clientProfiles = new ArrayList<>() { {
            add(secondClient);
            add(thirdClient);
            add(firstClient);
            add(fiveClient);
            add(fourClient);
        } };
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collectDistinctSorted(clientProfiles);

        List<Address> expected = new ArrayList<>() { {
            add(new Address("Kazan", "Pravo-Bulachnaya", 5, 25));
            add(new Address("Moscow", "Tverskaya", 1, 5));
            add(new Address("Ufa", "Pushkina", 7, 7));
        } };

        assertThat(result, is(expected));

    }

}