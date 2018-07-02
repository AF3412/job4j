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

    private List<E> asList(Node<E> root) {
        List<E> result = new ArrayList<>();
        for (Node<E> node : root.leaves()) {
            result.add(node.value);
            if (!node.leaves().isEmpty()) {
                result.addAll(asList(node));
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return asList(root).iterator();
    }


}
