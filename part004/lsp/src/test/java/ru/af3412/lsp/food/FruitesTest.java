package ru.af3412.lsp.food;

import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Filatov Alexander
 * @since 26.11.2016
 */
public class FruitesTest {

    /**
     * Check expiry date.
     *
     * @throws Exception the exception
     */
    @Test
    public void checkExpiryFruitesDate() throws Exception {

        final int year = 2015;
        final int createDay = 10;
        final int expiryDay = 20;
        final int todayDay = 13;
        final int breadPrice = 10;


        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        LocalDate todayDate = LocalDate.of(year, Month.NOVEMBER, todayDay);
        final int expected = 30;

        Food bread = new Fruites("white", createDate, expiryDate, breadPrice);

        int result = bread.checkExpiryDate(todayDate);

        assertThat(expected, is(result));

    }


}