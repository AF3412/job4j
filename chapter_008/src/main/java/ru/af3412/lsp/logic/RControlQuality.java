package ru.af3412.lsp.logic;

import ru.af3412.dip.food.FoodRecycle;
import ru.af3412.dip.storage.RStorage;

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
     * The control quality for foods without using "can reproduct".
     */
    private ControlQuality controlQuality = new ControlQuality();

    /**
     * Sets control quality.
     *
     * @param controlQuality the control quality
     */
    public void setControlQuality(ControlQuality controlQuality) {
        this.controlQuality = controlQuality;
    }

    /**
     * Gets control quality.
     *
     * @return the control quality
     */
    public ControlQuality getControlQuality() {
        return controlQuality;
    }

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
        boolean member = false;
        for (RStorage storage : foodStorage) {
            if (storage != null) {
                if (storage.checkExpirationDate(food, localDate) && (food.getCanReproduct())) {
                    storage.choiceStorage(food, localDate);
                    member = true;
                    break;
                } else {
                    this.controlQuality.moveFood(food.getFood(), localDate);
                }
            }

        }
    }
}
