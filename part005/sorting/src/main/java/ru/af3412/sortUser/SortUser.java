package ru.af3412.sortUser;

import java.util.*;

/**
 * Created by Филатов on 08.04.2017.
 */
public class SortUser {

    private TreeSet<User> setUsers;

    /**
     * Sort set.
     *
     * @param listUsers the list users
     * @return the set
     */
    Set<User> sort(List<User> listUsers) {

        setUsers = new TreeSet<>();
        for (User user : listUsers) {
            setUsers.add(user);
        }

        return setUsers;
    }

    /**
     * Sort hash list.
     *
     * @param users the users
     * @return the list
     */
    public List<User> sortHash(List<User> users) {
        Collections.sort(users, new UserHashCodeComparator());

        return users;
    }

    /**
     * Sort length list.
     *
     * @param users the users
     * @return the list
     */
    public List<User> sortLength(List<User> users) {

        Collections.sort(users, new UserStringLengthComparator());

        return users;
    }

}
