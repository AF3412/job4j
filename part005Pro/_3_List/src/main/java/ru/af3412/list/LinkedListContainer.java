package ru.af3412.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by AF on 18.11.2017.
 *
 * @param <E> is generic.
 */
public class LinkedListContainer<E> implements Iterable {

    /**
     * размер свзяного списка.
     */
    private int size = 0;

    /**
     * Первый опорный элемент списка.
     * Значение "element" всегда null.
     * prev всегда null.
     * next указывает на первый элемент списка.
     */
    private Node<E> firstNode;

    /**
     * Последний опорный элемент списка.
     * Значение "element" всегда null.
     * prev указывает на последний элемент списка.
     * next всегда null.
     */
    private Node<E> lastNode;

    /**
     * Текущий элемент списка.
     * Необходим для добавления новых элементов списка.
     */
    private Node<E> currentNode;

    /**
     * Конструктор по-умолчанию. Создает опорные элементы.
     */
    public LinkedListContainer() {
        this.firstNode = new Node<>(null, null, this.lastNode);
        this.lastNode = new Node<>(null, this.firstNode, null);
    }

    /**
     * Возвращает размер (количество элементов) списка.
     *
     * @return this.size. size
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Проверка того, что контейнер пустой.
     *
     * @return true если пустой.
     */
    public boolean isEmpty() {
        return (this.size == 0);
    }

    /**
     * Возврещает итератор листа.
     *
     * @return iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    /**
     * добавляем элемент в конец листа.
     *
     * @param element объект, который добавляем.
     */
    public void add(E element) {
        if (currentNode == null) {
            Node<E> node = new Node<>(element, firstNode, lastNode);
            node.prev.next = node;
            node.next.prev = node;
            currentNode = node;
        } else {
            Node<E> node = new Node<>(element, currentNode, lastNode);
            node.prev.next = node;
            node.next.prev = node;
            currentNode = node;
        }
        size++;
    }

    /**
     * Добавляем элемент, вставляя его по индексу.
     *
     * @param index   индекс, куда надо вставить элемент.
     * @param element сам элемент.
     * @throws IndexOutOfBoundsException если выходит за пределы листа.
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (!checkSize(index)) {
            throw new IndexOutOfBoundsException();
        }
        if (this.size == 0) {
            this.add(element);
        } else {
            Node<E> tmpNode = findNode(index);
            Node<E> newNode = new Node<>(element, tmpNode.prev, tmpNode);
            tmpNode.prev.next = newNode;
            tmpNode.prev = newNode;
            this.size++;
        }
    }

    /**
     * Возвращаем значение из Node по индексу.
     *
     * @param index номер элемента который надо вернуть.
     * @return значение из Node.
     * @throws IndexOutOfBoundsException если выходит за пределы листа/
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (!checkSize(index)) {
            throw new IndexOutOfBoundsException();
        }
        return findNode(index).element;
    }

    /**
     * Удаляем элемент по индексу.
     *
     * @param index который надо удалить.
     * @throws IndexOutOfBoundsException если выходит за пределы листа.
     */
    public void remove(int index) throws IndexOutOfBoundsException {
        if (!checkSize(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> tmpNode = findNode(index);
        tmpNode.prev.next = tmpNode.next;
        tmpNode.next.prev = tmpNode.prev;
        tmpNode = null;
        size--;
    }

    /**
     * Удаление элемента по его значению.
     *
     * @param value искомый элемент.
     */
    public void remove(E value) {
        this.remove(findElement(value));
    }

    /**
     * Поиск элемента по значению.
     *
     * @param value значение.
     * @return индекс данного элемента.
     */
    public int findElement(E value) {
        int result = -1;
        Node<E> tmpNode = firstNode.next;
        for (int i = 0; i < size; i++) {
            if (tmpNode.element.equals(value)) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * Ищем Node по индексу.
     *
     * @param index номер Node.
     * @return Node по индексу.
     * @throws IndexOutOfBoundsException может выкинуть исключение, если выходит за пределы листа.
     */
    private Node<E> findNode(int index) throws IndexOutOfBoundsException {
        if (!checkSize(index)) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> result = firstNode.next;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }

    /**
     * Проверка на выход за пределы листа.
     *
     * @param index проверка, что элемент находится в пределах листа.
     * @return true or false.
     */
    private boolean checkSize(int index) {
        return (index >= 0 && index < this.size);
    }

    /**
     * Узел списка. Содержит значение и указатели на следующий и предыдущий элементы.
     *
     * @param <T> любое значение.
     */
    private class Node<T> {

        /**
         * The Element.
         */
        private T element;

        /**
         * The Next.
         */
        private Node<T> next;

        /**
         * The Prev.
         */
        private Node<T> prev;

        /**
         * Instantiates a new Node.
         *
         * @param element the element
         * @param prev    the prev
         * @param next    the next
         */
        Node(T element, Node<T> prev, Node<T> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * Итератор.
     */
    private class Itr implements Iterator<E> {
        /**
         * Указатель на элемент.
         */
        private int cursor = 0;

        /**
         * Проверяем не вышли ли мы за пределы листа.
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        /**
         * Берем текущий элемент и переходим на следующий.
         *
         * @return возвращаем текущий элемент.
         * @throws NoSuchElementException если следующий элемент не существует.
         */
        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = findNode(cursor).element;
            cursor++;
            return result;
        }
    }
}