package ru.af3412.sortUser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

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
        List<User> checked = Arrays.asList(user2, user1);

        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(sortUser.sort(users));

        assertThat(result, is(checked));
    }

    /**
     * When add three users with difference age return set users sorted by age.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddThreeUsersWithDifferenceAgeReturnSetUsersSortedByAge() throws Exception {
        User user1 = new User("A", 7);
        User user2 = new User("B", 1);
        User user3 = new User("C", 2);
        List<User> users = Arrays.asList(user1, user2, user3);
        List<User> checked = Arrays.asList(user2, user3, user1);

        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(sortUser.sort(users));

        assertThat(result, is(checked));

    }

    /**
     * When add two users with difference name length return set users sorted by name length using comparator.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddTwoUsersWithDifferenceNameLengthReturnSetUsersSortedByNameLengthUsingComparator() throws Exception {
        User user1 = new User("A", 2);
        User user2 = new User("BB", 1);
        List<User> users = Arrays.asList(user2, user1);
        List<User> checked = Arrays.asList(user1, user2);

        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(sortUser.sortLength(users));

        assertThat(result, is(checked));

    }

    /**
     * When add three users with difference name length return set users sorted by name length using comparator.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddThreeUsersWithDifferenceNameLengthReturnSetUsersSortedByNameLengthUsingComparator() throws Exception {
        User user1 = new User("A", 2);
        User user2 = new User("BB", 1);
        User user3 = new User("CCC", 1);
        List<User> users = Arrays.asList(user3, user1, user2);
        List<User> checked = Arrays.asList(user1, user2, user3);

        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(sortUser.sortLength(users));

        assertThat(result, is(checked));

    }

    /**
     * When add two difference users return set users sorted by hash.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddTwoDifferenceUsersReturnSetUsersSortedByHash() throws Exception {
        User user1 = new User("A", 2);
        User user2 = new User("BB", 1);
        List<User> users = Arrays.asList(user1, user2);
        Integer hashOne = user1.hashCode();
        Integer hashTwo = user2.hashCode();
        List<User> checked;

        checked = (hashOne < hashTwo) ? Arrays.asList(user1, user2) : Arrays.asList(user2, user1);

        SortUser sortUser = new SortUser();
        List<User> result = new ArrayList<>();
        result.addAll(sortUser.sortHash(users));

        assertThat(result, is(checked));

    }

}