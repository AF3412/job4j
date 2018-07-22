package ru.af3412.lsp.storage;

import ru.af3412.dip.food.Food;

import java.time.LocalDate;

/**
 * The type Warehouse.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class Warehouse extends FoodStorage {


    @Override
    public void choiceStorage(Food food, LocalDate localDate) {
        super.addFood(food);
    }

    /**
     * Check expiration date boolean.
     *
     * @param food      the food
     * @param localDate the local date
     *                  qualityFood is parameter for check food quality
     * @return the boolean
     */

    @Override
    public boolean checkExpirationDate(Food food, LocalDate localDate) {

        final int qualityFood = 25;

        return (food.checkExpiryDate(localDate) < qualityFood);

    }


}
