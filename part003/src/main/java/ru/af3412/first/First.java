package ru.af3412.first;

/**
 * @author Filatov Alexander
 * @since 14.09.2016
 * This program checks the number and outputs the result is an even number or not
 */

import java.util.Scanner;

/**
 * The type First.
 */
public class First {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
/**
 * @param sc is the number entered from the keyboard
 */
        Scanner sc = new Scanner(System.in);

/**
 * Check the number entered from the keyboard, integer or not
 */
        if (!sc.hasNextInt()) {
            System.out.println("This is not an integer");
        }
        /**
         * Check even number or not
         */
        else {
            CheckNumber cn = new CheckNumber(sc.nextInt());
            System.out.print(cn.checked());
        }

    }


}
