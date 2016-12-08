package ru.af3412.lsp.storage;

import ru.af3412.lsp.food.Food;

import java.time.LocalDate;

/**
 * The type New warehouse.
 *
 * @author Filatov Alexander
 * @since 08.12.2016
 */
public class NewWarehouse extends Warehouse {

    @Override
    public void choiceStorage(Food food, LocalDate localDate) {
        super.choiceStorage(food, localDate);
    }

    @Override
    public boolean checkExpirationDate(Food food, LocalDate localDate) {
        return super.checkExpirationDate(food, localDate);
    }

}
