package pool;

import java.util.concurrent.RecursiveTask;

public class ParallelFinder<T> extends RecursiveTask<Integer> {

    private final T[] array;
    private final T value;
    private final int from;
    private final int to;

    public ParallelFinder(T[] array, T value) {
        this(array, value, 0, array.length - 1);
    }

    public ParallelFinder(T[] array, T value, int from, int to) {
        this.array = array;
        this.value = value;
        this.from = from;
        this.to = to;
    }

    @Override
    protected Integer compute() {
        if (from == to) {
            if (array[from].equals(value)) {
                return from;
            }
            return -1;
        }
        int mid = (from + to) / 2;
        ParallelFinder<T> leftFind = new ParallelFinder<>(array, value, from, mid);
        ParallelFinder<T> rightFind = new ParallelFinder<>(array, value, mid + 1, to);
        leftFind.fork();
        rightFind.fork();
        int left = leftFind.join();
        int right = rightFind.join();
        if (left != -1) {
            return left;
        }
        return right;
    }

}
