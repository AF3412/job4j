package ru.af3412.set;

import ru.af3412.list.DynamicListArray;

import java.util.Iterator;

/**
 * Created by AF on 26.12.2017.
 *
 * @param <E> is generic.
 */
public class SimpleSet<E> implements Iterable<E> {

    /**
     * Используем композицию, т.к. реализация кода идентичная.
     */
    private DynamicListArray<E> dynamicListArray;

    /**
     * Конструктор по-умолчанию создает коллекцию размером в 100 элементов.
     */
    public SimpleSet() {
        this(100);
    }

    /**
     * Конструктор с указанием размера коллекции.
     *
     * @param size указывает необходимый размер коллекции.
     */
    public SimpleSet(int size) {
        this.dynamicListArray = new DynamicListArray<>(size);
    }

    /**
     * Добавление уникального элемента в коллекцию.
     *
     * @param value - элемент, который надо добавить в коллекцию.
     */
    public void add(E value) {
        boolean isFind = true;
        for (E findValue : dynamicListArray) {
            if (findValue.equals(value)) {
                isFind = false;
                break;
            }
        }
        if (isFind) {
            dynamicListArray.add(value);
        }

    }

    /**
     * Метод возвращает размер коллекции.
     *
     * @return collection size.
     */
    public int getSize() {
        return dynamicListArray.getSize();
    }

    /**
     * Реализуем итератор.
     *
     * @return возвращает итератор коллекции DynamicListArray, т.к. реализация идентичная.
     */
    @Override
    public Iterator<E> iterator() {
        return dynamicListArray.iterator();
    }

}
