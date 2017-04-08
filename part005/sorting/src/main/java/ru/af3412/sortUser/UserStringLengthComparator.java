package ru.af3412.sortUser;

import java.util.Comparator;

/**
 * Created by Филатов on 08.04.2017.
 */
public class UserStringLengthComparator implements Comparator<User> {

    public int compare(User first, User second) {
        return first.name.length() - second.name.length();
    }

}
