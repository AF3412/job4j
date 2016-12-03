package ru.af3412.lsp.logic;

import ru.af3412.lsp.food.Food;
import ru.af3412.lsp.storage.FoodStorage;

import java.time.LocalDate;

/**
 * The type Control quality.
 *
 * @author Filatov Alexander
 * @since 03.12.2016
 */
public class ControlQuality {

    /**
     * The number storage.
     */
    private final int numberStorages = 10;

    /**
     * The count for storages array.
     */
    private int countStorages = 0;

    /**
     * The Food storage.
     */
    private FoodStorage[] foodStorage = new FoodStorage[numberStorages];

    /**
     * Add storages.
     *
     * @param storage the storage
     */
    public void addStorages(FoodStorage storage) {
        this.foodStorage[countStorages++] = storage;
    }

    /**
     * Get food storage food storage [ ].
     *
     * @return the food storage [ ]
     */
    public FoodStorage[] getFoodStorage() {
        return foodStorage;
    }

    /**
     * Add food.
     *
     * @param food      the food
     * @param localDate the local date
     */
    public void moveFood(Food food, LocalDate localDate) {
        for (FoodStorage storage : foodStorage) {
            if (storage != null) {
                storage.addFood(food, localDate);
            }
        }
    }

}
