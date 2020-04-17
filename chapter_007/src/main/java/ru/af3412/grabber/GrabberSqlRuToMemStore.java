package ru.af3412.grabber;

import java.util.List;

public class GrabberSqlRuToMemStore implements Grab {

    private static final String SITE_URL = "https://www.sql.ru/forum/job-offers/1";

    /**
     * Initialize grabber vacancy system
     * @param parse is parser site with vacancy
     * @param store is post storage
     */
    @Override
    public void init(Parse parse, Store store) {
        List<Post> postList = parse.list(SITE_URL);
        for (Post post : postList) {
            post.setText(parse.detail(post.getLink()).getText());
            store.save(post);
        }
    }

}
