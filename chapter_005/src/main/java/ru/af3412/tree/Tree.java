package ru.af3412.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;

    public Tree(E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {

        Optional<Node<E>> node = this.findBy(parent);

        if (!node.isPresent()) {
            throw new IllegalArgumentException(String.format("Parent not found: %s", parent));
        }

        return node.get().add(new Node<>(child));
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    private Set<E> asList(Node<E> root) {
        /*Set<Node<E>> result = new HashSet<>();
        for (Node<E> node : root.leaves()) {
            result.add(node);
            if (!node.leaves().isEmpty()) {
                result.addAll(asList(node));
            }
        }*/
        Set<E> result = new HashSet<>();
        for (Node<E> node : root.leaves()) {
            result.add(node.value);
            if (!node.leaves().isEmpty()) {
                result.addAll(asList(node));
            }
        }
        result.add(root.value);
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return asList(this.root).iterator();
    }

    public boolean isBinary() {
        for (E value : this) {
            Optional<Node<E>> node = findBy(value);
            if (node.isPresent()) {
                if (node.get().leaves().size() > 2) {
                    return false;
                }
            }
        }
        return true;

    }

}