package ru.af3412.lsp.logic;

import org.junit.Before;
import org.junit.Test;
import ru.af3412.lsp.food.Bread;
import ru.af3412.lsp.food.Food;
import ru.af3412.lsp.storage.FoodStorage;
import ru.af3412.lsp.storage.Shop;
import ru.af3412.lsp.storage.Trash;
import ru.af3412.lsp.storage.Warehouse;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Control quality test.
 *
 * @author Filatov Alexander
 * @since 03.12.2016
 */
public class ControlQualityTest {

    /**
     * The new storage is Trash.
     */
    private FoodStorage trash = new Trash();

    /**
     * The new storage is Shop.
     */
    private FoodStorage shop = new Shop();

    /**
     * The new storage is Warehouse.
     */
    private FoodStorage warehouse = new Warehouse();

    /**
     * The control quality.
     */
    private ControlQuality cq = new ControlQuality();
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
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {

        cq.addStorages(trash);
        cq.addStorages(shop);
        cq.addStorages(warehouse);

    }

    /**
     * When add storage that control quality return this storage.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddStorageThatControlQualityReturnThisStorage() throws Exception {

        FoodStorage result = cq.getFoodStorage().get(0);

        assertThat(trash, is(result));

    }

    /**
     * When add food with date more expiry date that food add to trash.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithDateMoreExpiryDateThatFoodAddToTrash() throws Exception {

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);
        final int todayNow = 20;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);

        cq.moveFood(bread, today);

        Food result = cq.getFoodStorage().get(0).getStorage().get(0);

        assertThat(bread, is(result));

    }

    /**
     * When add food with date less expiry date that food add to shop.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithDateLessExpiryDateThatFoodAddToShop() throws Exception {

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);
        final int todayNow = 15;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);

        cq.moveFood(bread, today);

        Food result = cq.getFoodStorage().get(1).getStorage().get(0);

        assertThat(bread, is(result));

    }

    /**
     * When add food with date new that food add to warehouse.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithDateNewThatFoodAddToWarehouse() throws Exception {

        LocalDate createDate = LocalDate.of(year, Month.NOVEMBER, createDay);
        LocalDate expiryDate = LocalDate.of(year, Month.NOVEMBER, expiryDay);
        Food bread = new Bread("white", createDate, expiryDate, breadPrice);
        final int todayNow = 11;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);

        cq.moveFood(bread, today);

        Food result = cq.getFoodStorage().get(2).getStorage().get(0);

        assertThat(bread, is(result));

    }

}