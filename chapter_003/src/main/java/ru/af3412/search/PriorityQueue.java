package ru.af3412.search;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
    private List<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;

        for (var element : tasks) {
            if (element.getPriority() > task.getPriority()) {
                tasks.add(index, task);
                return;
            } else {
                index++;
            }
        }
        tasks.add(index, task);
    }

    public Task take() {
        return tasks.remove(0);
    }
}
