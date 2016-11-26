package ru.af3412.lsp.storage;

import ru.af3412.lsp.food.Food;

/**
 * The type Food storage.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class FoodStorage {

    /**
     * The Amount food.
     */
    private final int amountFood = 10;

    /**
     * The Storage.
     */
    private Food[] storage = new Food[amountFood];

    /**
     * The count for storage.
     */
    private int count = 0;

    /**
     * Add food.
     *
     * @param food the food
     */
    public void addFood(Food food) {
        storage[count++] = food;
    }

    /**
     * Get storage food [ ].
     *
     * @return the food [ ]
     */
    public Food[] getStorage() {
        return storage;
    }

}
