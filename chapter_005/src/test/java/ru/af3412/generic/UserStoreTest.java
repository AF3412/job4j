package ru.af3412.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

/**
 * Created by AF on 06.11.2017.
 */
public class UserStoreTest {

    /**
     * user store for all test.
     */
    private UserStore userStore;

    /**
     * Create data.
     */
    @Before
    public void createData() {
        userStore = new UserStore();
    }

    /**
     * When add new user return true.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddNewUserReturnTrue() throws Exception {
        User user = new User();
        user.setId("1");
        boolean result = userStore.add(user);

        assertThat(result, is(true));

    }

    /**
     * When add new user this user returned in get method.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddNewUserThisUserReturnedInGetMethod() throws Exception {
        User user = new User();
        user.setId("1");
        userStore.add(user);

        User result = (User) userStore.getValue("1");

        assertThat(result, is(user));

    }

    /**
     * When update value in storage then value is changed.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenUpdateValueInStorageThenValueIsChanged() throws Exception {
        User user = new User();
        User anotherUser = new User();
        user.setId("0");
        anotherUser.setId("1");
        userStore.add(user);

        userStore.update("0", anotherUser);
        User result = (User) userStore.getValue("1");

        assertThat(result, is(anotherUser));
    }

    /**
     * When delete value this value not find in storage.
     *
     * @throws Exception the exception
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenDeleteValueThisValueNotFindInStorage() throws Exception {

        User user = new User();
        user.setId("0");
        userStore.add(user);

        userStore.delete("0");

        User result = (User) userStore.getValue("0");

        assertNull(result);
    }

}