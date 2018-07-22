package ru.af3412.dip.storage;

import org.junit.Test;
import ru.af3412.dip.food.FoodRecycle;
import ru.af3412.dip.food.Fruites;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Cold storage test.
 *
 * @author Filatov Alexander
 * @since 13.12.2016
 */
public class ColdStorageTest {

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
    private final int price = 10;
    /**
     * The Create date.
     */
    private LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
    /**
     * The Expiry date.
     */
    private LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
    /**
     * The fruit banana.
     */
    private FoodRecycle banana = new FoodRecycle(new Fruites("yelow", createDate, expiryDate, price), true);
    /**
     * The vegetable potato.
     */
    private FoodRecycle potato = new FoodRecycle(new Fruites("yelow", createDate, expiryDate, price), false);

    /**
     * When add fod with date less expiry date and can reproduct that return false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFodWithDateLessExpiryDateAndCanReproductThatReturnFalse() throws Exception {
        final int todayNow = 20;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        RStorage coldStorage = new ColdStorage();
        boolean expectation = false;

        boolean result = coldStorage.checkExpirationDate(banana, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add fod with good date and can reproduct that return true.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFodWithGoodDateAndCanReproductThatReturnTrue() throws Exception {
        final int todayNow = 11;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        RStorage coldStorage = new ColdStorage();
        boolean expectation = true;

        boolean result = coldStorage.checkExpirationDate(banana, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add fod with date less expiry date and cant reproduct that return false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFodWithDateLessExpiryDateAndCantReproductThatReturnFalse() throws Exception {
        final int todayNow = 19;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        RStorage coldStorage = new ColdStorage();
        boolean expectation = false;

        boolean result = coldStorage.checkExpirationDate(potato, today);

        assertThat(expectation, is(result));
    }


    /**
     * When add fod with good date and cant reproduct that return false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFodWithGoodDateAndCantReproductThatReturnFalse() throws Exception {
        final int todayNow = 11;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        RStorage coldStorage = new ColdStorage();
        boolean expectation = false;

        boolean result = coldStorage.checkExpirationDate(potato, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add food that cold storage return this food.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodThatColdStorageReturnThisFood() throws Exception {

        final int todayNow = 11;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        RStorage coldStorage = new ColdStorage();

        coldStorage.choiceStorage(banana, today);

        FoodRecycle result = coldStorage.getStorage().get(0);

        assertThat(banana, is(result));

    }

}