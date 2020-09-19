package pool;

import org.junit.Test;

public class ThreadPoolTest {


    @Test
    public void singleThreadTimeTest() {
        Counter counter = new Counter();
        long start = System.nanoTime();
        for (int i = 0; i < 500; i++) {
            counter.count(i);
        }
        System.out.println("Execution time: " + (System.nanoTime() - start) / 100_000_000);
    }

    @Test
    public void threadPoolTimeTest() {
        Counter counter = new Counter();
        long start = System.nanoTime();
        ThreadPool threadPool = new ThreadPool();
        for (int i = 0; i < 500; i++) {
            int finalI = i;
            threadPool.work(() -> counter.count(finalI));
        }
        threadPool.shutdown();
        System.out.println("Execution time: " + (System.nanoTime() - start) / 100_000_000);
    }

}