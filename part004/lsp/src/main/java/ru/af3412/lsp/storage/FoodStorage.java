package ru.af3412.lsp.storage;

import ru.af3412.lsp.food.Food;

import java.time.LocalDate;

/**
 * The type Food storage.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public abstract class FoodStorage {

    /**
     * Storage size.
     */
    private final int storageSize = 10;

    /**
     * The Storage.
     */
    private Food[] storage = new Food[storageSize];

    /**
     * The count for storage.
     */
    private int count = 0;

    /**
     * Add food if the expiry date has passed.
     *
     * @param food      the food
     * @param localDate the local date
     */
    public void addFood(Food food, LocalDate localDate) {
        if (checkExpirationDate(food, localDate)) {
            storage[count++] = food;
        }
    }

    /**
     * Check expiration date boolean.
     * Need @overraid for every storage
     *
     * @param food      the food
     * @param localDate the local date
     * @return the boolean
     */
    protected abstract boolean checkExpirationDate(Food food, LocalDate localDate);

    /**
     * Get storage food [ ].
     *
     * @return the food [ ]
     */
    public Food[] getStorage() {
        return storage;
    }

}
