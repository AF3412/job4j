package atom.bank;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class UserStorageTest {

    private UserStorage userStorage;
    private User one;
    private User two;

    @Before
    public void prepareTests() {
        userStorage = new UserStorage();
        one = new User(1, 10);
        two = new User(2, 20);
    }

    @Test
    public void whenAddUsersThenReturnSizeIsTwo() {
        userStorage.add(one);
        userStorage.add(two);
        assertThat(userStorage.get().size(), is(2));
    }

    @Test
    public void whenTransferBetweenUsersThenUsersAmountChange() {
        userStorage.add(one);
        userStorage.add(two);
        userStorage.transfer(2, 1, 5);
        assertThat(one.amount, is(15));
        assertThat(two.amount, is(15));
    }

    @Test
    public void whenDeleteUserThenStorageSizeChanged() {
        userStorage.add(one);
        userStorage.add(two);
        boolean del = this.userStorage.delete(one);
        assertTrue(del);
        assertThat(userStorage.get().size(), is(1));
    }

    @Test
    public void whenUpdateUserThenUserDataUpdated() {
        userStorage.add(one);
        userStorage.add(two);
        User updatedUser = new User(1, 30);
        boolean updated = this.userStorage.update(updatedUser);
        assertTrue(updated);
        assertThat(one.amount, is(30));
    }

}