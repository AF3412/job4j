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

    public SimpleBlockingQueue() {
        this(10);
    }

    public SimpleBlockingQueue(int limit) {
        this.limit = limit;
    }

    public synchronized Queue<T> getQueue() {
        return queue;
    }

    public synchronized void offer(T value) throws InterruptedException {
        while (queue.size() >= limit) {
            this.wait();
        }
        queue.add(value);
        this.notify();
    }

    public synchronized T poll() throws InterruptedException {
        while (isEmpty()) {
            this.wait();
        }
        T result = queue.poll();
        this.notify();
        return result;
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }
}
