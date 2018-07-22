package ru.af3412.lsp.food;

import java.time.LocalDate;

/**
 * The type Preserves.
 *
 * @author Filatov Alexander
 * @since 13.11.2016
 */
public class Preserves extends Food {

    /**
     * Instantiates a new Food.
     *
     * @param name       the name
     * @param createDate the create date
     * @param expiryDate the expiry date
     * @param price      the price
     */
    public Preserves(String name, LocalDate createDate, LocalDate expiryDate, int price) {
        super(name, createDate, expiryDate, price);
    }

}
