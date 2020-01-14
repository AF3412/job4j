package ru.af3412.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {

    private final Profile firstClient = new Profile(new Address("Kazan", "Baumana", 1, 5));
    private final Profile secondClient = new Profile(new Address("Kazan", "Pravo-Bulachnaya", 5, 25));
    private final Profile thirdClient = new Profile(new Address("Kazan", "Pushkina", 7, 7));

    private final List<Profile> clientProfiles = new ArrayList<>() { {
        add(firstClient);
        add(secondClient);
        add(thirdClient);
    } };


    /*
    В туристической компании появилась задача составить список адресов клиентов.
    */
    @Test
    public void whenCollectClientsAddressThenReturnListAddress() {

        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(clientProfiles);

        List<Address> expected = new ArrayList<>() { {
            add(new Address("Kazan", "Baumana", 1, 5));
            add(new Address("Kazan", "Pravo-Bulachnaya", 5, 25));
            add(new Address("Kazan", "Pushkina", 7, 7));
        } };

        assertThat(result, is(expected));

    }

}