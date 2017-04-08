package ru.af3412.sortUser;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Филатов on 08.04.2017.
 */
public class SortUser {

    private TreeSet<User> setUsers = new TreeSet<>();

    /**
     * Sort set.
     *
     * @param listUsers the list users
     * @return the set
     */
    Set<User> sort(List<User> listUsers) {
        for (User user : listUsers) {
            setUsers.add(user);
        }

        return setUsers;
    }

}
