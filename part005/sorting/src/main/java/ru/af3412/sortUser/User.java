package ru.af3412.sortUser;

/**
 * Created by Филатов on 06.04.2017.
 */
public class User implements Comparable<User> {

    /**
     * The Name.
     */
    String name;
    /**
     * The Age.
     */
    int age;

    /**
     * Instantiates a new User.
     *
     * @param name the name
     * @param age  the age
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User user) {

        return this.age - user.age;
    }

}
