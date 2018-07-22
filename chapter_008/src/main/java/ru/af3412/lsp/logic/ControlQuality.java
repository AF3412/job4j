package ru.af3412.lsp.logic;

import ru.af3412.dip.food.Food;
import ru.af3412.dip.storage.FoodStorage;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type Control quality.
 *
 * @author Filatov Alexander
 * @since 03.12.2016
 */
public class ControlQuality {

    /**
     * The Food storage.
     */
    private ArrayList<FoodStorage> foodStorage = new ArrayList<>();

    /**
     * Add storages.
     *
     * @param storage the storage
     */
    public void addStorages(FoodStorage storage) {
        this.foodStorage.add(storage);
    }

    /**
     * Get food storage food storage [ ].
     *
     * @return the food storage [ ]
     */
    public ArrayList<FoodStorage> getFoodStorage() {
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
                if (storage.checkExpirationDate(food, localDate)) {
                    storage.choiceStorage(food, localDate);
                    break;
                }
            }
        }
    }

}
