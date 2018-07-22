package ru.af3412.lsp.storage;

import ru.af3412.dip.food.Food;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Food storage.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public abstract class FoodStorage {

    /**
     * The Storage.
     */
    private ArrayList<Food> storage = new ArrayList<>();

    /**
     * Add food.
     *
     * @param food the food
     */
    public void addFood(Food food) {
        this.storage.add(food);
    }

    /**
     * Get storage food [ ].
     *
     * @return the food [ ]
     */
    public ArrayList<Food> getStorage() {
        return storage;
    }

    /**
     * Add food if the expiry date has passed.
     *
     * @param food      the food
     * @param localDate the local date
     */
    public abstract void choiceStorage(Food food, LocalDate localDate);

    /**
     * Check expiration date boolean.
     * Need @overraid for every storage
     *
     * @param food      the food
     * @param localDate the local date
     * @return the boolean
     */
    public abstract boolean checkExpirationDate(Food food, LocalDate localDate);

}
