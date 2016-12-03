package ru.af3412.lsp.storage;

import ru.af3412.lsp.food.Food;

import java.time.LocalDate;

/**
 * The type Warehouse.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class Warehouse extends FoodStorage {

    /**
     * The quality food.
     */
    private final int qualityFood = 25;


    @Override
    public boolean checkExpirationDate(Food food, LocalDate localDate) {

        return (food.checkExpiryDate(localDate) < qualityFood);

    }

}
