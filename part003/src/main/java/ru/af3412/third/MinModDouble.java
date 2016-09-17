package ru.af3412.third;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Filatov Alexander
 * @since 17.09.2016
 */
public class MinModDouble {

    /**
     * @param number how much value you can enter
     * @param scanner init input system
     * @param array is array values
     * @param index is count of array
     */
    private final int number = 3;
    Scanner scanner = new Scanner(System.in);
    double[] array = new double[number];
    int index = 0;

    /**
     * Class enterValueWithAbs for the input value and recording their absolute values in array
     */
    public void enterValueWithAbs() {
        do {
            System.out.print("Please enter value: ");
            this.array[index++] = Math.abs(this.scanner.nextDouble());
        }
        while (index != array.length);
    }

    /**
     * sorts the array to increase
     * @return first value after sorted (it's min value)
     */
    public double minValue() {
        Arrays.sort(this.array);
        return (this.array[0]);
    }



}
