package ru.af3412.lsp.storage;

import ru.af3412.lsp.food.Food;

import java.time.LocalDate;

/**
 * The type Shop.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class Shop extends FoodStorage {


    /**
     * The quality fresh food.
     */
    private final int qualityFreshFood = 25;

    /**
     * The quality stale food.
     */
    private final int qualityStaleFood = 75;

    /**
     * The quality bad food.
     */
    private final int qualityBadFood = 100;

    /**
     * The food discount.
     */
    private final int discount = 25;

    @Override
    public boolean checkExpirationDate(Food food, LocalDate localDate) {

        boolean value = false;
        int stateFood = food.checkExpiryDate(localDate);

        if ((stateFood >= qualityFreshFood) && (stateFood) < qualityStaleFood) {
            value = true;
        } else if ((stateFood >= qualityStaleFood) && (stateFood) < qualityBadFood) {
            food.setDisscount(discount);
            value = true;
        }

        return value;

    }
}