package ru.af3412.third;

/**
 * The type Start min double.
 *
 * @author Filatov Alexander
 * @since 17.09.2016
 */
public class StartMinDouble {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        /**
         * mdd is instance of the class MinModDouble
         */
        MinModDouble mdd = new MinModDouble();

        /**
         * Enter values to class mdd array
         */
        mdd.enterValueWithAbs();
        /**
         * Displays the first element of the array
         */
        System.out.print("Min absolute value: " + mdd.minValue());

    }

}
