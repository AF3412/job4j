package ru.af3412.list;

import java.util.NoSuchElementException;

/**
 * Created by AF on 15.12.2017.
 */
public abstract class SimpleContainer<T> {

    /**
     * Коллекция, с помощью которой реализуется SimpleContainer.
     */
    protected LinkedListContainer<T> container = new LinkedListContainer<>();

    /**
     * Метод возвращает размер коллекции.
     * @return размер коллекции.
     */
    public int size() {
        return container.getSize();
    }

    /**
     * Метод для добавления элемента в коллекцию.
     * @param value елемент, который будет добавлен в коллекцию.
     */
    public void push(T value) {
        container.add(value);
    }

    /**
     * Метод возвращает элемент из коллекции.
     * @return элемент коллекции и удаляет его.
     * @throws NoSuchElementException если размер коллекции равен 0.
     */
    abstract T poll() throws NoSuchElementException;

}
