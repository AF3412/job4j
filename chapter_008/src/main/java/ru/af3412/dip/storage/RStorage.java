package ru.af3412.dip.storage;

import ru.af3412.dip.food.FoodRecycle;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Recycle storage.
 *
 * @author Filatov Alexander
 * @since 09.12.2016
 */
public abstract class RStorage {

    /**
     * The Storage.
     */
    private ArrayList<FoodRecycle> storage = new ArrayList<>();

    /**
     * Add food.
     *
     * @param foodRecycle the food recycle
     */
    public void addFood(FoodRecycle foodRecycle) {
        this.storage.add(foodRecycle);
    }

    /**
     * Gets food storage.
     *
     * @return the food storage
     */
    public ArrayList<FoodRecycle> getFoodStorage() {
        return storage;
    }

    /**
     * Add food if the expiry date has passed.
     *
     * @param food      the food
     * @param localDate the local date
     */
    public abstract void choiceStorage(FoodRecycle food, LocalDate localDate);

    /**
     * Check expiration date boolean.
     * Need @overraid for every storage
     *
     * @param food      the food
     * @param localDate the local date
     * @return the boolean
     */
    public abstract boolean checkExpirationDate(FoodRecycle food, LocalDate localDate);


    /**
     * Gets storage.
     *
     * @return the storage
     */
    public ArrayList<FoodRecycle> getStorage() {
        return storage;
    }
}
