package ru.af3412.search;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PriorityQueueTest {
    @Test
    public void whenHigherPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle", 3));
        Task result = queue.take();
        assertThat(result.getDesc(), is("urgent"));
    }

    @Test
    public void whenHigherBeforeLowerPriority() {
        PriorityQueue queue = new PriorityQueue();
        queue.put(new Task("low", 5));
        queue.put(new Task("urgent", 1));
        queue.put(new Task("middle-low", 4));
        queue.put(new Task("middle", 3));

        List<Task> result = new LinkedList<>();
        result.add(0, new Task("urgent", 1));
        result.add(1, new Task("middle", 3));
        result.add(2, new Task("middle-low", 4));
        result.add(3, new Task("low", 5));

        for (var elem : result) {
            assertThat(elem, is(queue.take()));
        }
    }
}