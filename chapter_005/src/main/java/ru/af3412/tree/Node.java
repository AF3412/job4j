package ru.af3412.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node<E extends Comparable<E>> {

    private final List<Node<E>> children = new ArrayList<>();
    final E value;

    public Node(final E value) {
        this.value = value;
    }

    public boolean add(Node<E> child) {
        boolean notExists = !children.contains(child);
        if (notExists) {
            children.add(child);
        }

        return notExists;
    }

    public List<Node<E>> leaves() {
        return this.children;
    }

    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Node)) {
            return false;
        }
        Node<?> node = (Node<?>) o;
        return Objects.equals(children, node.children) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, value);
    }
}