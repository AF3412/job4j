package ru.af3412.dip.food;

import java.time.LocalDate;

/**
 * The type Bread.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class Bread extends Food {

    /**
     * Instantiates a new Food.
     *
     * @param name       the name
     * @param createDate the create date
     * @param expiryDate the expiry date
     * @param price      the price
     */
    public Bread(String name, LocalDate createDate, LocalDate expiryDate, int price) {
        super(name, createDate, expiryDate, price);
    }

}
