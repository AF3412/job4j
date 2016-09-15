package ru.af3412.second;

import java.util.Scanner;

/**
 * @author Filatov Alexander
 * @since 15.09.2016
 */
public class Summ {

    public static void main(String[] args) {

        /**
         * @param numOne is first number
         * @param numSec is second number
         * @param err is indicator integer
         */

        int numOne = 0;
        int numSec = 0;
        boolean err = false;

        /**
         * @param sc is the number entered from the keyboard
         */
        Scanner sc = new Scanner(System.in);

/**
 * Check the number entered from the keyboard, integer or not
 */
        if (!sc.hasNextInt()) {
            System.out.println("This is not an integer");
            err = true;
        } else {
            numOne = sc.nextInt();
        }

        if (!sc.hasNextInt()) {
            System.out.println("This is not an integer");
            err = true;
        } else {
            numSec = sc.nextInt();
        }

        /**
         * If err = true then program not work
         */
        if (!err) {
            SummOfTwo summOfTwo = new SummOfTwo(numOne, numSec);
            System.out.println(summOfTwo.summ());
        }


    }


}
