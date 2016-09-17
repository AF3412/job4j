package ru.af3412.second;

/**
 * @author Filatov Alexander
 * @since 15.09.2016

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
