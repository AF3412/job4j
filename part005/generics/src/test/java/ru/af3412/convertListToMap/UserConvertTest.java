package ru.af3412.convertListToMap;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by Филатов on 05.04.2017.
 */
public class UserConvertTest {

    /**
     * When give one user return map with id user.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenGiveOneUserReturnMapWithIdUser() throws Exception {

        UserConvert userConvert = new UserConvert();
        User user = new User(1, "Joe", "Moscow");
        List<User> users = Arrays.asList(user);
        Map<Integer, User> checked = new HashMap<>();
        checked.put(1, user);

        HashMap<Integer, User> result = userConvert.process(users);

        assertThat(result, is(checked));

    }

    /**
     * When give two user return map with two id user.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenGiveTwoUserReturnMapWithTwoIdUser() throws Exception {

        UserConvert userConvert = new UserConvert();
        User user = new User(1, "Joe", "Moscow");
        User user2 = new User(2, "Alan", "Samara");
        List<User> users = Arrays.asList(user, user2);
        Map<Integer, User> checked = new HashMap<>();
        checked.put(1, user);
        checked.put(2, user2);

        HashMap<Integer, User> result = userConvert.process(users);

        assertThat(result, is(checked));

    }

}