package nonblocking;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NonBlockingCacheTest {


    @Test
    public void whenAddTwoValuesThenSizeIsTwo() throws InterruptedException {
        NonBlockingCache cache = new NonBlockingCache();
        Base one = new Base(1, 0);
        Base two = new Base(2, 0);

        Thread threadOne = new Thread(() -> cache.add(one));
        Thread threadTwo = new Thread(() -> cache.add(two));

        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();

        assertThat(cache.size(), is(2));
    }

    @Test
    public void whenUpdateValuesThenVersionUpdated() {
        NonBlockingCache cache = new NonBlockingCache();
        Base one = new Base(1, 1);
        Base changed = new Base(1, 2);
        cache.add(one);
        cache.update(changed);

        assertThat(cache.get(one.id).version, is(1));
    }


    @Test
    public void whenThrowException() throws InterruptedException {
        AtomicReference<Exception> ex = new AtomicReference<>();
        NonBlockingCache cache = new NonBlockingCache();

        Base one = new Base(1, 1);
        cache.add(one);
        Base changeOne = new Base(1, 0, 2);
        Base changeTwo = new Base(1, 0, 3);


        Thread threadOne = new Thread(
                () -> {
                    try {
                        cache.update(changeOne);
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                }
        );
        Thread threadTwo = new Thread(
                () -> {
                    try {
                        cache.update(changeTwo);
                    } catch (OptimisticException e) {
                        ex.set(e);
                    }
                }
        );
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        assertThat(ex.get().getMessage(), is("Object change two or more threads at the same time!"));
    }


}