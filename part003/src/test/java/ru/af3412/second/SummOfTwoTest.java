package ru.af3412.second;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Filatov Alexander
 * @since 15.09.2016
 */
public class SummOfTwoTest {

    @Test
    public void testSumm() {

        int numOne = 1;
        int numSec = 1;
        int sumOneSec = numOne + numSec;

        SummOfTwo summOfTwo = new SummOfTwo(numOne, numSec);

        assertThat(summOfTwo.summ(), is(sumOneSec));

    }

}