package ru.af3412.convertListToMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Филатов on 05.04.2017.
 */
public class UserConvert {

    /**
     * Process hash map.
     *
     * @param list the list
     * @return the hash map
     */
    public HashMap<Integer, User> process(List<User> list) {
        Iterator<User> iterator = list.iterator();
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            if (iterator.hasNext()) {
                result.put(user.getId(), user);
            }
        }

        return result;

    }

}
