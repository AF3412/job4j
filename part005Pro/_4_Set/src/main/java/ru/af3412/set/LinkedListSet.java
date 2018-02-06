package ru.af3412.set;

import ru.af3412.list.LinkedListContainer;

import java.util.Iterator;

/**
 * Created by AF on 06.02.2018.
 */
public class LinkedListSet<E> implements Iterable<E> {

    /**
     * Используем композицию, т.к. реализация кода идентичная.
     */
    private LinkedListContainer<E> linkedListContainer;

    /**
     * Конструктор по-умолчанию.
     */
    public LinkedListSet() {
        this.linkedListContainer = new LinkedListContainer<>();
    }

    /**
     * Добавление элемента в коллекцию.
     * Проверяет уникальность через метод isDuplicate.
     *
     * @param value - элемент, который надо добавить в коллекцию.
     */
    public void add(E value) {
        if (!isDuplicate(value)) {
            this.linkedListContainer.add(value);
        }
    }

    /**
     * Метод возвращает размер коллекции.
     *
     * @return collection size.
     */
    public int getSize() {
        return linkedListContainer.getSize();
    }

    /**
     * Проверка элемента на уникальность.
     *
     * @param value - элемент, который надо добавить в коллекцию.
     * @return true, если элемент является дубликатом. False, если элемент уникальный.
     */
    private boolean isDuplicate(E value) {
        return (linkedListContainer.findElement(value) != -1);
    }

    /**
     * Итератор.
     *
     * @return возвращает итератор коллекции LinkedListContainer, т.к. реализация идентичная.
     */
    @Override
    public Iterator<E> iterator() {
        return linkedListContainer.iterator();
    }

}
