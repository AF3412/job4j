package ru.af3412.grabber;

import java.util.List;

public interface Parse {
    List<Post> list(String link);
    Post detail(String link);
}
