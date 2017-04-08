package ru.af3412.sortUser;

import java.util.Comparator;

/**
 * Created by Филатов on 08.04.2017.
 */
public class UserHashCodeComparator implements Comparator<User> {

    public int compare(User first, User second) {
        Integer firstHash = first.hashCode();
        Integer secondHash = second.hashCode();
        return firstHash.compareTo(secondHash);
    }

}