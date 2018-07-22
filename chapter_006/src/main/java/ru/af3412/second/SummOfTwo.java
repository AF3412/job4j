package ru.af3412.second;

/**
 * The type Summ of two.
 *
 * @author Filatov Alexander
 * @since 15.09.2016 <p> This class returned sum of two integer values
 */
public class SummOfTwo {

    /**
     * The Num one.
     */
    int numOne;
    /**
     * The Num sec.
     */
    int numSec;

    /**
     * Instantiates a new Summ of two.
     *
     * @param numOne the num one
     * @param numSec the num sec
     */
    public SummOfTwo(int numOne, int numSec) {
        this.numOne = numOne;
        this.numSec = numSec;
    }


    /**
     * Summ int.
     *
     * @return the int
     */
    public int summ() {
        return (this.numOne + this.numSec);
    }

}
