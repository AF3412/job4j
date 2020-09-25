package pool;

import wait.SimpleBlockingQueue;

import java.util.LinkedList;
import java.util.List;

public class ThreadPool {

    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();

    private final List<Thread> threads = new LinkedList<>();
    private final SimpleBlockingQueue<Runnable> tasks;

    public ThreadPool() {
        tasks = new SimpleBlockingQueue<>();
        for (int i = 0; i < AVAILABLE_PROCESSORS; i++) {
            threads.add(new Thread(new Task(tasks)));
        }
        threads.forEach(Thread::start);
    }

    public void work(Runnable job) {
        try {
            tasks.offer(job);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdown() {
        threads.forEach(Thread::interrupt);
    }

    private static final class Task implements Runnable {
        private final SimpleBlockingQueue<Runnable> tasks;

        public Task(SimpleBlockingQueue<Runnable> tasks) {
            this.tasks = tasks;
        }

        @Override
        public void run() {
            try {
                while (!tasks.isEmpty() || !Thread.currentThread().isInterrupted()) {
                    Runnable element = this.tasks.poll();
                    new Thread(element).start();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}