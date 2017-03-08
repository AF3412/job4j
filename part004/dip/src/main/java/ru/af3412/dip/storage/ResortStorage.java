package ru.af3412.dip.storage;

import ru.af3412.dip.food.Food;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Filatov Alexander
 * @since 05.03.2017
 */
public class ResortStorage extends FoodStorage {

    private ArrayList<Food> storage = new ArrayList<>();

    @Override
    public void choiceStorage(Food food, LocalDate localDate) {

    }

    @Override
    public boolean checkExpirationDate(Food food, LocalDate localDate) {
        return false;
    }
}
