package ru.af3412.map;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by AF on 02.04.2018.
 */
public class UserTest {

    /**
     * Test calendar.
     */
    @Test
    public void testMap() {
        Calendar calendar = new GregorianCalendar(2018, 4, 2);
        User userOne = new User("Alex", 2, calendar);
        User userTwo = new User("Alex", 2, calendar);

        Map<User, Object> testMap = new HashMap<>();
        testMap.put(userOne, new Object());
        testMap.put(userTwo, new Object());

        System.out.println(testMap);
    }


}