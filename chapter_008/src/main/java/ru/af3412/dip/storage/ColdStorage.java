package ru.af3412.dip.storage;


import ru.af3412.dip.food.FoodRecycle;

import java.time.LocalDate;

/**
 * The type Cold storage.
 *
 * @author Filatov Alexander
 * @since 12.12.2016
 */
public class ColdStorage extends RStorage {


    @Override
    public void choiceStorage(FoodRecycle food, LocalDate localDate) {
        super.addFood(food);
    }

    @Override
    public boolean checkExpirationDate(FoodRecycle food, LocalDate localDate) {

        final int qualityFood = 25;
        return ((food.checkExpiryDate(localDate) < qualityFood) && food.getCanReproduct());

    }


}
