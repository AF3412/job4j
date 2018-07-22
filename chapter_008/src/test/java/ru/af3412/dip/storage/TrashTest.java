package ru.af3412.dip.storage;

import org.junit.Test;
import ru.af3412.dip.food.Bread;
import ru.af3412.dip.food.Food;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * The type Trash test.
 *
 * @author Filatov Alexander
 * @since 26.11.2016
 */
public class TrashTest {

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
     * When add fod with date more expiry date that return true.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodWithDateMoreExpiryDateThatReturnTrue() throws Exception {

        final int todayNow = 20;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage trash = new Trash();
        boolean expectation = true;

        boolean result = trash.checkExpirationDate(bread, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add fod with date less expiry date that return false.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFodWithDateLessExpiryDateThatReturnFalse() throws Exception {

        final int todayNow = 15;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage trash = new Trash();
        boolean expectation = false;

        boolean result = trash.checkExpirationDate(bread, today);

        assertThat(expectation, is(result));
    }

    /**
     * When add food that trash return this food.
     *
     * @throws Exception the exception
     */
    @Test
    public void whenAddFoodThatTrashReturnThisFood() throws Exception {

        final int todayNow = 20;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage trash2 = new Trash();

        trash2.choiceStorage(bread, today);

        Food result = trash2.getStorage().get(0);

        assertThat(bread, is(result));

    }

    @Test
    public void whenCallMethodClearFoodThenClearAllStorageFood() {

        final int todayNow = 20;
        LocalDate today = LocalDate.of(year, Month.NOVEMBER, todayNow);
        FoodStorage trash3 = new Trash();

        trash3.choiceStorage(bread, today);
        trash3.clearFood();

        int result = trash3.getStorage().size();

        assertThat(result, is(0));

    }

}