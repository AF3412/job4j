package ru.af3412.sortUser;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;

/**
 * Created by Филатов on 08.04.2017.
 */
public class SortUser {

    /**
     * inner class - comparator for sorting by hash code.
     */
    private class UserHashCodeComparator implements Comparator<User> {
        /**
         * Compares two users by hash.
         */
        public int compare(User first, User second) {
            Integer firstHash = first.hashCode();
            Integer secondHash = second.hashCode();
            return firstHash.compareTo(secondHash);
        }
    }

    /**
     * inner class - comparator for sorting by length name.
     */
    private class UserStringLengthComparator implements Comparator<User> {
        /**
         * Compares two users by length name.
         */
        public int compare(User first, User second) {
            return first.name.length() - second.name.length();
        }
    }

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