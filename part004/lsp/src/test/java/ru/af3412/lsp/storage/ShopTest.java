package ru.af3412.lsp.storage;

import org.junit.Test;
import ru.af3412.lsp.food.Bread;
import ru.af3412.lsp.food.Food;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Warehouse test.
 *
 * @author Filatov Alexander
 * @since 26.11.2016
 */
public class ShopTest {

    /**
     * The Year.
     */
    private final int year = 2016;
    /**
     * The Create day.
     */
    private final int createDay = 10;
    /**
     * The Expiry day.
     */
    private final int expiryDay = 20;
    /**
     * The Bread price.
     */
    private final int breadPrice = 10;
    /**
     * The Create date.
     */
    private LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
    /**
     * The Expiry date.
     */
    private LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
    /**
     * The Bread.
     */
    private Food bread = new Bread("white", createDate, expiryDate, breadPrice);

    /**
     * When add food with date more expiry date that return true.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithDateMoreExpiryDateThatReturnTrue() throws Exception {

        final int todayNow = 15;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage shop = new Shop();
        boolean expectation = true;

        boolean result = shop.checkExpirationDate(bread, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add fod with date less expiry date that return false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFodWithDateLessExpiryDateThatReturnFalse() throws Exception {

        final int todayNow = 10;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage shop = new Shop();
        boolean expectation = false;

        boolean result = shop.checkExpirationDate(bread, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add food that shop return this food.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodThatWarehouseReturnThisFood() throws Exception {

        final int todayNow = 15;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage shop = new Shop();

        shop.addFood(bread, today);

        Food result = shop.getStorage()[0];

        assertThat(bread, is(result));

    }

    /**
     * When add food with expired period that product add discount.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithExpiredPeriodThatProductAddDiscount() throws Exception {

        final int todayNow = 19;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage shop = new Shop();
        final int expectation = 25;

        shop.addFood(bread, today);

        final int result = shop.getStorage()[0].getDiscount();

        assertThat(expectation, is(result));

    }

    /**
     * When add food with good period that product without discount.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithGoodPeriodThatProductWithoutDiscount() throws Exception {

        final int todayNow = 14;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage shop = new Shop();
        final int expectation = 0;

        shop.addFood(bread, today);

        final int result = shop.getStorage()[0].getDiscount();

        assertThat(expectation, is(result));

    }

}