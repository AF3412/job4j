package ru.af3412.map;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by AF on 02.04.2018.
 */
public class UserTest {

    /**
     * Test calendar.
     */
    @Test
    public void testCalendar() {
        Calendar calendar = new GregorianCalendar(2018, 4, 2);
        User userOne = new User("Alex", 2, calendar);
        User userTwo = new User("Alex", 2, calendar);
        Map<User, Object> testMap = new HashMap<>();
        testMap.put(userOne, new Object());
        testMap.put(userTwo, new Object());

        System.out.println(testMap);
        System.out.println(testMap.get(userOne));
        System.out.println(testMap.get(userTwo));
        System.out.println(testMap.get(userTwo));
        System.out.println(testMap.get(userTwo));
    }



}