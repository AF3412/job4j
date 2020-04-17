package ru.af3412.grabber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {
    private static final Logger LOG = LogManager.getLogger(Store.class.getName());
    private final List<Post> storePosts = new ArrayList<>(100);
    private long id = 0;

    /**
     * save new posts
     * @param post is job post
     */
    @Override
    public void save(Post post) {
        if (get(existPost -> existPost.getName().equals(post.getName())).size() == 0) {
            post.setId(idGenerator());
            this.storePosts.add(post);
        } else {
            LOG.warn("Duplicate post not save to base. {}", post.getName());
        }
    }

    /**
     * Get list posts which meet the condition
     * @param filter is condition
     * @return list posts after filtered
     */
    @Override
    public List<Post> get(Predicate<Post> filter) {
        return storePosts.stream()
                .filter(filter)
                .collect(Collectors.toList());
    }

    /**
     * Check this database is empty
     * @return true if database is empty
     */
    @Override
    public boolean isEmpty() {
        return this.storePosts.size() == 0;
    }

    /**
     * Generate id value for new post
     * @return long value with new id
     */
    private long idGenerator() {
        return this.id++;
    }

}
