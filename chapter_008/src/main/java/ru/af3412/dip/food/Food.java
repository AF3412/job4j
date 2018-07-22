package ru.af3412.dip.food;

import java.time.Duration;
import java.time.LocalDate;

/**
 * The type Food.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public abstract class Food {

    /**
     * The Name.
     */
    private String name;

    /**
     * The Create date.
     */
    private LocalDate createDate;

    /**
     * The expiry date.
     */
    private LocalDate expiryDate;

    /**
     * The Price.
     */
    private int price;

    /**
     * The discount.
     */
    private int discount;

    /**
     * The limit expiry date in percent.
     */
    private final int limit = 100;

    /**
     * Instantiates a new Food.
     *
     * @param name       the name
     * @param createDate the create date
     * @param expiryDate the expiry date
     * @param price      the price
     */
    public Food(String name, LocalDate createDate, LocalDate expiryDate, int price) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets create date.
     *
     * @return the create date
     */
    public LocalDate getCreateDate() {
        return createDate;
    }

    /**
     * Gets expiry date.
     *
     * @return the expiry date
     */
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    /**
     * Gets price.
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Gets discount.
     *
     * @return the discount
     */
    public int getDiscount() {
        return discount;
    }

    /**
     * Sets discount.
     *
     * @param discount the discount
     */
    public void setDisscount(int discount) {
        this.discount = discount;
    }

    /**
     * Check expiry date int.
     *
     * @param today the today
     * @return the int
     */
    public int checkExpiryDate(LocalDate today) {

        long expirationDate = Duration.between(
                this.createDate.atTime(0, 0), this.expiryDate.atTime(0, 0)
        ).toDays();
        long goneDate = Duration.between(
                this.createDate.atTime(0, 0), today.atTime(0, 0)
        ).toDays();

        return (int) (limit * goneDate / expirationDate);

    }

}
