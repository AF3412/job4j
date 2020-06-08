package ru.af3412.benchpost;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;

public class UserAgregatorTest {


    @Test
    public void whenAddOneUserThenBruteForceMergeReturnThatUser() {
        UserAgregator userAgregator = new UserAgregator();
        User user = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        List<User> users = List.of(user);
        List<User> result = userAgregator.mergeBruteForce(users);
        Assert.assertThat(user, is(result.get(0)));
    }

    @Test
    public void whenAddOneUserThenDFSMergeReturnThatUser() {
        UserAgregator userAgregator = new UserAgregator();
        User user = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        List<User> users = List.of(user);
        List<User> result = userAgregator.mergeDFS(users);
        Assert.assertThat(user, is(result.get(0)));
    }

    @Test
    public void whenAddTwoUsersWithoutSameEmailsThenBruteForceMergeReturnThatUsers() {
        var userAgregator = new UserAgregator();
        var user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var user2 = new User("user2", Set.of("yyy@ya.ru", "bar@gmail.com", "kek@mail.ru"));
        var users = new ArrayList<>(List.of(user1, user2));

        var result = userAgregator.mergeBruteForce(users);

        Assert.assertThat(user1, is(result.get(0)));
        Assert.assertThat(user2, is(result.get(1)));
    }

    @Test
    public void whenAddTwoUsersWithoutSameEmailsThenDFSMergeReturnThatUsers() {
        var userAgregator = new UserAgregator();
        var user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var user2 = new User("user2", Set.of("yyy@ya.ru", "bar@gmail.com", "kek@mail.ru"));
        var users = new ArrayList<>(List.of(user1, user2));

        var result = userAgregator.mergeDFS(users);

        Assert.assertThat(user2, is(result.get(0)));
        Assert.assertThat(user1, is(result.get(1)));
    }

    @Test
    public void whenAddTwoUsersWithSameEmailThenBruteForceMergeReturnNewUserListWithOneUser() {
        var userAgregator = new UserAgregator();
        var user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var user2 = new User("user2", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var users = new ArrayList<>(List.of(user1, user2));

        var expectedUser = new User("user2", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var result = userAgregator.mergeBruteForce(users);

        Assert.assertThat(result.size(), is(1));
        Assert.assertThat(result.get(0).emails, is(expectedUser.emails));
    }

    @Test
    public void whenAddTwoUsersWithSameEmailThenDFSMergeReturnNewUserListWithOneUser() {
        var userAgregator = new UserAgregator();
        var user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var user2 = new User("user2", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var users = new ArrayList<>(List.of(user1, user2));

        var expectedUser = new User("user2", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var result = userAgregator.mergeDFS(users);

        Assert.assertThat(result.size(), is(1));
        Assert.assertThat(result.get(0).emails, is(expectedUser.emails));
    }

    @Test
    public void whenAddFiveUsersWithMultiDuplicateEmailsThenBruteForceMergeReturnNewUserListWithTwoUser() {
        var userAgregator = new UserAgregator();
        var user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var user2 = new User("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        var user3 = new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        var user4 = new User("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        var user5 = new User("user5", Set.of("xyz@pisem.net"));
        var users = new ArrayList<>(List.of(user1, user2, user3, user4, user5));

        var expectedUser1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
        var expectedUser2 = new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        userAgregator.mergeDFS(users);
        var result = userAgregator.mergeBruteForce(users);
        Assert.assertThat(result.size(), is(2));
        Assert.assertThat(result.get(0).emails, is(expectedUser1.emails));
        Assert.assertThat(result.get(1).emails, is(expectedUser2.emails));
    }

    @Test
    public void whenAddFiveUsersWithMultiDuplicateEmailsThenDFSMergeReturnNewUserListWithTwoUser() {
        var userAgregator = new UserAgregator();
        var user1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru"));
        var user2 = new User("user2", Set.of("foo@gmail.com", "ups@pisem.net"));
        var user3 = new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        var user4 = new User("user4", Set.of("ups@pisem.net", "aaa@bbb.ru"));
        var user5 = new User("user5", Set.of("xyz@pisem.net"));
        var users = new ArrayList<>(List.of(user1, user2, user3, user4, user5));

        var expectedUser1 = new User("user1", Set.of("xxx@ya.ru", "foo@gmail.com", "lol@mail.ru", "ups@pisem.net", "aaa@bbb.ru"));
        var expectedUser2 = new User("user3", Set.of("xyz@pisem.net", "vasya@pupkin.com"));
        userAgregator.mergeDFS(users);
        var result = userAgregator.mergeDFS(users);

        Assert.assertThat(result.size(), is(2));
        Assert.assertThat(result.get(0).emails, is(expectedUser1.emails));
        Assert.assertThat(result.get(1).emails, is(expectedUser2.emails));
    }

}