package ru.af3412.second;

import java.util.Scanner;

/**
 * The type Summ.
 *
 * @author Filatov Alexander
 * @since 15.09.2016 Create a program that will calculate and display the sum of two integers entered by the user. If the user correctly will introduce at least one of the numbers, then report a bug.
 */
public class Summ {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        StartSum ss = new StartSum();

        ss.enterValue("Enter first value: ");
        ss.enterValue("Enter second value: ");
        System.out.println(ss.summ());

    }

}
