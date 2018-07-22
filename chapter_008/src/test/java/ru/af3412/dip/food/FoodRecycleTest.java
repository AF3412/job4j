package ru.af3412.dip.food;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Food recycle test.
 *
 * @author Filatov Alexander
 * @since 10.12.2016
 */
public class FoodRecycleTest {
    /**
     * The year.
     */
    private final int year = 2015;

    /**
     * The create day.
     */
    private final int createDay = 10;

    /**
     * The expiry day.
     */
    private final int expiryDay = 20;

    /**
     * The today.
     */
    private final int todayDay = 13;

    /**
     * The price.
     */
    private final int price = 10;

    /**
     * Can reproduct.
     */
    private final boolean canReproduct = true;

    /**
     * The create date.
     */
    private LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);

    /**
     * The expiry day.
     */
    private LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);

    /**
     * The today.
     */
    private LocalDate todayDate = LocalDate.of(year, Month.NOVEMBER, todayDay);

    /**
     * The banana.
     */
    private Food banana = new Fruites("banana", createDate, expiryDate, price);

    /**
     * The recycle banana.
     */
    private FoodRecycle bananaR = new FoodRecycle(banana, canReproduct);

    /**
     * Check expiry date.
     *
     * @throws Exception the exception
     */
    @Test
    public void checkExpiryDate() throws Exception {

        int result = bananaR.checkExpiryDate(todayDate);
        final int expected = 30;

        assertThat(expected, is(result));

    }

    /**
     * Gets can reproduct.
     *
     * @throws Exception the exception
     */
    @Test
    public void getCanReproduct() throws Exception {

        boolean result = bananaR.getCanReproduct();
        final boolean expected = true;

        assertThat(expected, is(result));

    }

    /**
     * Gets name.
     *
     * @throws Exception the exception
     */
    @Test
    public void getName() throws Exception {

        String result = bananaR.getName();
        final String expected = "banana";

        assertThat(expected, is(result));

    }

}