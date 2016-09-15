package ru.af3412.second;

/**
 * @author Filatov Alexander
 * @since 15.09.2016
 * <p>
 * Create a program that will calculate and display the sum of two integers entered by the user.
 * If the user correctly will introduce at least one of the numbers, then report a bug.
 */
public class SummOfTwo {

    int numOne;
    int numSec;

    public SummOfTwo(int numOne, int numSec) {
        this.numOne = numOne;
        this.numSec = numSec;
    }


    public int summ() {
        return (this.numOne + this.numSec);
    }

}
