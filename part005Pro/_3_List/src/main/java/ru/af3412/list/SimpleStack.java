package ru.af3412.list;

import java.util.NoSuchElementException;

/**
 * Created by AF on 15.12.2017.
 * реализует коллекцию состоящую из абстрактных типов данных,
 * представляющий собой список элементов, организованных по принципу LIFO
 * (англ. last in — first out, «последним пришёл — первым вышел»
 */
public class SimpleStack<T> extends SimpleContainer<T> {

    /**
     * Метод возврщает последний элемент из коллекции.
     * @return элемент коллекции и удаляет его.
     * @throws NoSuchElementException если размер коллекции равен 0.
     */
    public T poll() throws NoSuchElementException {
        T result;
        if (!container.isEmpty()) {
            result = container.get(container.getSize() - 1);
            container.remove(container.getSize() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }

}
