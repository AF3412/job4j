package atom.bank;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UserStorageTest {

    public static class ThreadUserStorage extends Thread {
        private final UserStorage userStorage;

        private ThreadUserStorage(final UserStorage userStorage) {
            this.userStorage = userStorage;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }

    }

    @Test
    public void whenCreateTwoUsersFromTwoThreadsReturnSizeIsTwo() throws InterruptedException {
        UserStorage userStorage = new UserStorage();
        User one = new User(1, 10);
        User two = new User(2, 20);
        Thread first = new ThreadUserStorage(userStorage);
        Thread second = new ThreadUserStorage(userStorage);
        first.start();
        second.start();
        userStorage.add(one);
        userStorage.add(two);
        first.join();
        second.join();
        assertThat(userStorage.get().size(), is(2));
    }

}