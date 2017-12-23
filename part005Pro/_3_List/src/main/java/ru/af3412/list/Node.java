package ru.af3412.list;

/**
 * Created by AF on 19.12.2017.
 *
 * @param <T> the type parameter
 */
public class Node<T> {

    private T value;
    /**
     * The Next.
     */
    Node<T> next;

    /**
     * Instantiates a new Node.
     *
     * @param value the value
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Has cycle boolean.
     * ПРоверяет не зациклен ли односвязный список.
     * @param first the first
     * @return the boolean
     */
    boolean hasCycle(Node first) {
        if (first == null) {
            return false;
        }
        if (first.next == null) {
            return false;
        }

        Node nextNode = first.next;

        for (; ; ) {
            if (first == nextNode) {
                return true;
            }
            if (first.next == null) {
                return false;
            }

            first = first.next;
            if (nextNode.next == null || nextNode.next.next == null) {
                return false;
            } else {
                nextNode = nextNode.next.next;
            }
        }

    }
}