package pool;

import java.util.concurrent.ForkJoinPool;

public class Finder<T> {

    public int find(T[] array, T value) {
        if (array.length < 10) {
            return new SequenceFinder<T>().find(array, value);
        }
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        return forkJoinPool.invoke(new ParallelFinder<>(array, value));
    }


}
