package ru.af3412.second;

import java.util.Scanner;

/**
 * The type Start sum.
 *
 * @author Filatov Alexander
 * @since 16.09.2016
 */
public class StartSum {

    /**
     * The Number.
     *
     * @param number is array of integer;
     * @param index is count for array "number"
     * @param err is boolean value of integer number or not
     */
    int[] number = new int[2];
    /**
     * The Index.
     */
    int index = 0;
    /**
     * The Err.
     */
    boolean err = false;

    /**
     * Method "enterValue" check for a integer and add in an array. If value not a integer, then param err change tu true
     *
     * @param ask printing message
     */
    public void enterValue(String ask) {
        System.out.print(ask);
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            this.err = true;
        } else {
            number[index++] = scanner.nextInt();
        }
    }

    /**
     * Method summ() returned text
     *
     * @return returned text; value Sum or error message
     */
    public String summ() {
        String text;
        if (!err) {
            text = String.format("Sum: %s", (new SummOfTwo(number[0], number[1])).summ());
        } else {
            text = ("One of the numbers is not an integer");
        }
        return text;
    }


}
