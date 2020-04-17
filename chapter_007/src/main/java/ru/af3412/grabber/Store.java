package ru.af3412.grabber;

import java.util.List;
import java.util.function.Predicate;

public interface Store {
    void save(Post post);
    List<Post> get(Predicate<Post> filter);
    boolean isEmpty();
}
