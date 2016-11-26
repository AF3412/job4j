package ru.af3412.lsp.storage;

import org.junit.Test;
import ru.af3412.lsp.food.Bread;
import ru.af3412.lsp.food.Food;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Filatov Alexander
 * @since 26.11.2016
 */
public class TrashTest {

    /**
     * Add food.
     *
     * @throws Exception the exception
     */
    @Test
    public void addFood() throws Exception {

        final int year = 2016;
        final int createDay = 10;
        final int expiryDay = 20;
        final int breadPrice = 10;
        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);
        FoodStorage trash = new Trash();

        trash.addFood(bread);

        Food result = trash.getStorage()[0];

        assertThat(bread, is(result));


    }

}