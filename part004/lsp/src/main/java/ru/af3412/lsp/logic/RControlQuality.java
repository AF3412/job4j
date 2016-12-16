package ru.af3412.lsp.logic;

import ru.af3412.lsp.food.FoodRecycle;
import ru.af3412.lsp.storage.RStorage;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The type R control quality.
 *
 * @author Filatov Alexander
 * @since 09.12.2016
 */
public class RControlQuality {

    /**
     * The Storage for recycle food.
     */
    private ArrayList<RStorage> foodStorage = new ArrayList<>();

    /**
     * Add storages.
     *
     * @param storage the storage
     */
    public void addStorages(RStorage storage) {
        this.foodStorage.add(storage);
    }

    /**
     * Gets food storage.
     *
     * @return the food storage
     */
    public ArrayList<RStorage> getFoodStorage() {
        return foodStorage;
    }

    /**
     * Move food.
     *
     * @param food      the food
     * @param localDate the local date
     */
    public void moveFood(FoodRecycle food, LocalDate localDate) {
        for (RStorage storage : foodStorage) {
            if (storage != null) {
                if (storage.checkExpirationDate(food, localDate) && (food.getCanReproduct())) {
                    storage.choiceStorage(food, localDate);
                    break;
                }
            }
        }
    }
}
