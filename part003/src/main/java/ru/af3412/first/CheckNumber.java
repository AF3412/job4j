package ru.af3412.first;

/**
 * The type Check number.
 *
 * @author Filatov Alexander
 * @since 14.09.2016
 */
public class CheckNumber {

    /**
     * The Num.
     *
     * @param num is the integer number
     */
    int num;

    /**
     * Instantiates a new Check number.
     *
     * @param num the num
     */
    public CheckNumber(int num) {
        this.num = num;
    }

    /**
     * Check even number or not
     *
     * @return the string
     */
    public String checked() {
        String text;
        if (num % 2 == 0) {
            text = "This is an even number";
        } else {
            text = "This is an odd number";
        }
        return text;
    }

}
