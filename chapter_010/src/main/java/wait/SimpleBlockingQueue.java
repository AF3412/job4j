package wait;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.LinkedList;
import java.util.Queue;

@ThreadSafe
public class SimpleBlockingQueue<T> {

    private final int limit;

    @GuardedBy("this")
    private final Queue<T> queue = new LinkedList<>();

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized Queue<T> getQueue() {
        return queue;
    }

    public synchronized void offer(T value) {
        try {
            if (queue.size() == limit) {
                this.wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        queue.add(value);
        this.notify();
    }

    public synchronized T poll() {
        try {
            if (queue.size() == 0) {
                this.wait();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        T result = queue.poll();
        this.notify();
        return result;
    }
}
