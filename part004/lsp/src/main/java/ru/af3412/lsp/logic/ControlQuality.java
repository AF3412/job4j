package ru.af3412.lsp.logic;


import ru.af3412.lsp.food.Food;
import ru.af3412.lsp.storage.FoodStorage;
import ru.af3412.lsp.storage.Shop;
import ru.af3412.lsp.storage.Trash;
import ru.af3412.lsp.storage.Warehouse;

import java.time.LocalDate;

/**
 * The type Control quality.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class ControlQuality {

    /**
     * The Any food.
     */
    private FoodStorage anyFood;

    /**
     * The Local date.
     */
    private LocalDate localDate;

    /**
     * Instantiates a new Control quality.
     *
     * @param anyFood   the any food
     * @param localDate the local date
     */
    public ControlQuality(FoodStorage anyFood, LocalDate localDate) {
        this.anyFood = anyFood;
        this.localDate = localDate;
    }

    /**
     * The freshFood.
     */
    private final int freshFood = 25;

    /**
     * The staleFood.
     */
    private final int staleFood = 75;

    /**
     * The badFood. For spoiled food.
     */
    private final int badFood = 100;

    /**
     * The discount.
     */
    private final int discount = 25;

    /**
     * The Shop.
     */
    private FoodStorage shop = new Shop();

    /**
     * The Ware house.
     */
    private FoodStorage wareHouse = new Warehouse();

    /**
     * The Trash.
     */
    private FoodStorage trash = new Trash();

    /**
     * Gets shop.
     *
     * @return the shop
     */
    public FoodStorage getShop() {
        return shop;
    }

    /**
     * Gets warehouse.
     *
     * @return the ware house
     */
    public FoodStorage getWareHouse() {
        return wareHouse;
    }

    /**
     * Gets trash.
     *
     * @return the trash
     */
    public FoodStorage getTrash() {
        return trash;
    }

    /**
     * Move food.
     */
    void moveFood() {

        for (Food food : anyFood.getStorage()) {

            if (food != null) {

                int checkDate = food.checkExpiryDate(this.localDate);

                if (checkDate < freshFood) {
                    this.wareHouse.addFood(food);
                } else if ((checkDate > freshFood) && (checkDate < staleFood)) {
                    this.shop.addFood(food);
                } else if ((checkDate > staleFood) && (checkDate < badFood)) {
                    food.setDisscount(discount);
                    this.shop.addFood(food);
                } else if (checkDate > badFood) {
                    this.trash.addFood(food);
                }

            }
        }
    }


}
