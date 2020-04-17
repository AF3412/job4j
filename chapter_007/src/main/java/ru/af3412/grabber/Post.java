package ru.af3412.grabber;

import java.util.Objects;

public class Post {

    private long id;
    private String name;
    private String text;
    private String link;

    public Post(String name, String link) {
        this.name = name;
        this.link = link;
    }

    public Post(String name, String text, String link) {
        this.name = name;
        this.link = link;
        this.text = text;
    }

    public Post(long id, String name, String text, String link) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        if (id != post.id) {
            return false;
        }
        if (!Objects.equals(name, post.name)) {
            return false;
        }
        if (!Objects.equals(text, post.text)) {
            return false;
        }
        return Objects.equals(link, post.link);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }
}
