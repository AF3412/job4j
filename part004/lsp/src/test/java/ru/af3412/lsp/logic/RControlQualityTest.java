package ru.af3412.lsp.logic;

import org.junit.Before;
import org.junit.Test;
import ru.af3412.lsp.food.FoodRecycle;
import ru.af3412.lsp.food.Fruites;
import ru.af3412.lsp.storage.ColdStorage;
import ru.af3412.lsp.storage.RStorage;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type R control quality test.
 *
 * @author Filatov Alexander
 * @since 14.12.2016
 */
public class RControlQualityTest {

    /**
     * The new storage is Trash.
     */
    private RStorage coldStorage = new ColdStorage();

    /**
     * The control quality.
     */
    private RControlQuality rcq = new RControlQuality();
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
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        rcq.addStorages(coldStorage);

    }

    /**
     * When add storage that control quality return this storage.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddStorageThatControlQualityReturnThisStorage() throws Exception {

        RStorage result = rcq.getFoodStorage().get(0);

        assertThat(coldStorage, is(result));

    }

    /**
     * When add food with date more expiry date that food add to trash.
     *
     * @throws Exception the exception
     */

    /**
     * When add food with date new that food add to warehouse.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithDateNewThatFoodAddToColdStorage() throws Exception {

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        FoodRecycle banana = new FoodRecycle(new Fruites("yelow", createDate, expiryDate, price), true);
        final int todayNow = 11;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);

        rcq.moveFood(banana, today);

        FoodRecycle result = rcq.getFoodStorage().get(0).getStorage().get(0);

        assertThat(banana, is(result));

    }

    /**
     * When add food cant reproduction that storage is empty.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodCantReproductionThatStorageIsEmpty() throws Exception {

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        FoodRecycle banana = new FoodRecycle(new Fruites("yelow", createDate, expiryDate, price), false);
        final int todayNow = 11;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);

        rcq.moveFood(banana, today);
        int expected = 0;

        int result = rcq.getFoodStorage().get(0).getStorage().size();

        assertThat(expected, is(result));

    }

}