package pool;

import java.util.stream.IntStream;

public class SequenceFinder<T> {

    public int find(T[] array, T value) {
        return IntStream.range(0, array.length)
                .filter(i -> array[i].equals(value))
                .findFirst()
                .orElse(-1);
    }

}
