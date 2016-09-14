package ru.af3412.first;

/**
 * @author Filatov Alexander
 * @since 14.09.2016
 */
public class CheckNumber {

    /**
    * @param num is the integer number
    */
    int num;

    public CheckNumber(int num) {
        this.num = num;
    }

    /**
     * Check even number or not
     */
    public String checked() {
        String text;
        if (num % 2 == 0) {
            text = String.format("This is an even number");
        } else {
            text = String.format("This is an odd number");
        }
        return text;
    }

}
