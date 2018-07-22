package ru.af3412.convertlisttomap;

import java.util.HashMap;
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
        HashMap<Integer, User> result = new HashMap<>();
        for (User user : list) {
            result.put(user.getId(), user);
        }

        return result;

    }

}
