package ru.af3412.sortUser;

import org.junit.Test;

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
        StringBuilder stringBuilder = new StringBuilder();
        String checked = "B 1A 2";

        SortUser sortUser = new SortUser();
        for (User user : sortUser.sort(users)) {
            stringBuilder = stringBuilder.append(user.name).append(" ").append(user.age);
        }
        String result = stringBuilder.toString();

        assertThat(result, is(checked));
    }

    /**
     * When add three users with difference age return set users sorted by age.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddThreeUsersWithDifferenceAgeReturnSetUsersSortedByAge() throws Exception {
        User user1 = new User("A", 2);
        User user2 = new User("B", 1);
        User user3 = new User("C", 5);
        List<User> users = Arrays.asList(user1, user2, user3);
        StringBuilder stringBuilder = new StringBuilder();
        String checked = "B 1A 2C 5";

        SortUser sortUser = new SortUser();
        for (User user : sortUser.sort(users)) {
            stringBuilder = stringBuilder.append(user.name).append(" ").append(user.age);
        }
        String result = stringBuilder.toString();

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
        List<User> users = Arrays.asList(user1, user2);
        StringBuilder stringBuilder = new StringBuilder();
        String checked = "A 2BB 1";

        SortUser sortUser = new SortUser();
        for (User user : sortUser.sortLength(users)) {
            stringBuilder = stringBuilder.append(user.name).append(" ").append(user.age);
        }
        String result = stringBuilder.toString();

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
        StringBuilder stringBuilder = new StringBuilder();
        String checked = "A 2BB 1CCC 1";

        SortUser sortUser = new SortUser();
        for (User user : sortUser.sortLength(users)) {
            stringBuilder = stringBuilder.append(user.name).append(" ").append(user.age);
        }
        String result = stringBuilder.toString();

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
        StringBuilder stringBuilder = new StringBuilder();
        Integer hashOne = user1.hashCode();
        Integer hashTwo = user2.hashCode();

        String checked = (hashOne < hashTwo) ? "A 2BB 1" : "BB 1A 2";

        SortUser sortUser = new SortUser();
        for (User user : sortUser.sortHash(users)) {
            stringBuilder = stringBuilder.append(user.name).append(" ").append(user.age);
        }
        String result = stringBuilder.toString();

        assertThat(result, is(checked));

    }

}