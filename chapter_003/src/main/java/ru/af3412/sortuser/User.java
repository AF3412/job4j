package ru.af3412.sortuser;

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
    Integer age;

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

    /**
     * Override method compareTo
     *
     * @param user
     * @return result compare age
     */
    @Override
    public int compareTo(User user) {

        return age.compareTo(user.age);

    }

}
