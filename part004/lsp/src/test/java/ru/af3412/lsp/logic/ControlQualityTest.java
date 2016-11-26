package ru.af3412.lsp.logic;

import org.junit.Test;
import ru.af3412.lsp.food.Bread;
import ru.af3412.lsp.food.Food;
import ru.af3412.lsp.storage.FoodStorage;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * The type Control quality test.
 *
 * @author Filatov Alexander
 * @since 26.11.2016
 */
public class ControlQualityTest {

    /**
     * Move food.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMoveFreshFood() throws Exception {

        final int year = 2016;
        final int createDay = 10;
        final int expiryDay = 20;
        final int todayDay = 11;
        final int breadPrice = 10;

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        LocalDate todayDate = LocalDate.of(year, Month.NOVEMBER, todayDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);

        FoodStorage foodStorage = new FoodStorage();
        foodStorage.addFood(bread);

        ControlQuality cq = new ControlQuality(foodStorage, todayDate);
        cq.moveFood();
        FoodStorage expectedStorage = cq.getWareHouse();
        Food expectedFood = expectedStorage.getStorage()[0];

        assertThat(expectedFood, is(bread));

    }

    /**
     * Test move stale food.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMoveStaleFood() throws Exception {

        final int year = 2016;
        final int createDay = 10;
        final int expiryDay = 20;
        final int todayDay = 13;
        final int breadPrice = 10;

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        LocalDate todayDate = LocalDate.of(year, Month.NOVEMBER, todayDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);

        FoodStorage foodStorage = new FoodStorage();
        foodStorage.addFood(bread);

        ControlQuality cq = new ControlQuality(foodStorage, todayDate);
        cq.moveFood();
        FoodStorage expectedStorage = cq.getShop();
        Food expectedFood = expectedStorage.getStorage()[0];

        assertThat(expectedFood, is(bread));

    }

    /**
     * Test move trash food.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMoveTrashFood() throws Exception {

        final int year = 2016;
        final int createDay = 10;
        final int expiryDay = 20;
        final int todayDay = 21;
        final int breadPrice = 10;

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        LocalDate todayDate = LocalDate.of(year, Month.NOVEMBER, todayDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);

        FoodStorage foodStorage = new FoodStorage();
        foodStorage.addFood(bread);

        ControlQuality cq = new ControlQuality(foodStorage, todayDate);
        cq.moveFood();
        FoodStorage expectedStorage = cq.getTrash();
        Food expectedFood = expectedStorage.getStorage()[0];

        assertThat(expectedFood, is(bread));

    }

    /**
     * Test move stale food with discount.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMoveStaleFoodWithDiscount() throws Exception {

        final int year = 2016;
        final int createDay = 10;
        final int expiryDay = 20;
        final int todayDay = 19;
        final int breadPrice = 10;
        final int expectedPrice = 25;

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        LocalDate todayDate = LocalDate.of(year, Month.NOVEMBER, todayDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);

        FoodStorage foodStorage = new FoodStorage();
        foodStorage.addFood(bread);

        ControlQuality cq = new ControlQuality(foodStorage, todayDate);
        cq.moveFood();
        FoodStorage expectedStorage = cq.getShop();
        int resultFoodPrice = expectedStorage.getStorage()[0].getDiscount();

        assertThat(expectedPrice, is(resultFoodPrice));

    }


}