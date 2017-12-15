package ru.af3412.list;

import java.util.NoSuchElementException;

/**
 * Created by AF on 15.12.2017.
 * реализует коллекцию состоящую из абстрактных типов данных,
 * представляющий собой список элементов, организованных по принципу FIFO
 * (англ. first in — first out, «последним пришёл — первым вышел»
 */
public class SimpleQueue<T> extends SimpleContainer {

    private LinkedListContainer<T> container = super.container;

    /**
     * Метод возврщает первый элемент из коллекции.
     * @return элемент коллекции и удаляет его.
     * @throws NoSuchElementException если размер коллекции равен 0.
     */
    public T poll() throws NoSuchElementException {
        T result;
        if (!container.isEmpty()) {
            result = container.get(0);
            container.remove(0);
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

}
