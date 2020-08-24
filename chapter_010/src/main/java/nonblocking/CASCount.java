package nonblocking;

import net.jcip.annotations.ThreadSafe;

import java.util.concurrent.atomic.AtomicReference;

@ThreadSafe
public class CASCount {

    private final AtomicReference<Integer> count = new AtomicReference<>(0);

    public void increment() {
        int value;
        int next;
        do {
            value = this.get();
            next = value + 1;
        } while (!count.compareAndSet(value, next));

    }

    public int get() {
        return count.get();
    }
}
