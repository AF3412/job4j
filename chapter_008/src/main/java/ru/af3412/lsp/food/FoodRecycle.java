package ru.af3412.lsp.food;

import java.time.Duration;
import java.time.LocalDate;

/**
 * The type Food recycle.
 *
 * @author Filatov Alexander
 * @since 08.12.2016
 */
public class FoodRecycle {

    /**
     * The use of a decorator pattern.
     */
    private final Food food;

    /**
     * This field is responsible for the recyclability of the product.
     */
    private boolean canReproduct;

    /**
     * Instantiates a new Food recycle.
     *
     * @param food         the food
     * @param canReproduct the can reproduct
     */
    public FoodRecycle(final Food food, boolean canReproduct) {
        this.food = food;
        this.canReproduct = canReproduct;
    }

    /**
     * Gets food.
     *
     * @return the food
     */
    public Food getFood() {
        return food;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return food.getName();
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public LocalDate getCreateDate() {
        return food.getCreateDate();
    }

    /**
     * Gets expiry date.
     *
     * @return the expiry date
     */
    public LocalDate getExpiryDate() {
        return food.getExpiryDate();
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return food.getPrice();
    }

    /**
     * Gets discount.
     *
     * @return the discount
     */
    public int getDiscount() {
        return food.getDiscount();
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDisscount(int discount) {
        this.food.setDisscount(discount);
    }

    /**
     * Gets can reproduct.
     *
     * @return the can reproduct
     */
    public boolean getCanReproduct() {
        return canReproduct;
    }

    /**
     * Sets can reproduct.
     *
     * @param canReproduct the can reproduct
     */
    public void setCanReproduct(boolean canReproduct) {
        this.canReproduct = canReproduct;
    }

    /**
     * Check expiry date int.
     *
     * @param today the today
     * @return the int
     */
    public int checkExpiryDate(LocalDate today) {

        final int limit = 100;
        long expirationDate = Duration.between(
                this.food.getCreateDate().atTime(0, 0), this.food.getExpiryDate().atTime(0, 0)
        ).toDays();
        long goneDate = Duration.between(
                this.food.getCreateDate().atTime(0, 0), today.atTime(0, 0)
        ).toDays();

        return (int) (limit * goneDate / expirationDate);

    }


}
