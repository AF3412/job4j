package ru.af3412.sortUser;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Филатов on 08.04.2017.
 */
public class SortUserTest {
    /**
     * When add two users with difference age return set users sorted by age.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddTwoUsersWithDifferenceAgeReturnSetUsersSortedByAge() throws Exception {
        User user1 = new User("A", 2);
        User user2 = new User("B", 1);
        List<User> users = Arrays.asList(user1, user2);

        SortUser sortUser = new SortUser();
        for (User user : sortUser.sort(users)) {
            System.out.println(user.name + " " + user.age);
        }

    }

}