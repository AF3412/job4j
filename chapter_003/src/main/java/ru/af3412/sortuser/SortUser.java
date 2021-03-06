package ru.af3412.sortuser;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Филатов on 08.04.2017.
 */
public class SortUser {

    /**
     * Sort set.
     *
     * @param listUsers the list users
     * @return the set
     */
    Set<User> sort(List<User> listUsers) {
        TreeSet<User> setUsers = new TreeSet<>();
        setUsers.addAll(listUsers);
        return setUsers;
    }

    /**
     * Sort hash list.
     *
     * @param users the users
     * @return the list
     */
    public List<User> sortHash(List<User> users) {
        users.sort((first, second) -> {
            Integer firstHash = first.hashCode();
            Integer secondHash = second.hashCode();
            return firstHash.compareTo(secondHash);
        });
        return users;
    }

    /**
     * Sort length list.
     *
     * @param users the users
     * @return the list
     */
    public List<User> sortLength(List<User> users) {
        users.sort(Comparator.comparingInt(user -> user.name.length()));
        return users;
    }

}