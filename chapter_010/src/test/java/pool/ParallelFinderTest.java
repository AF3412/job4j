package pool;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParallelFinderTest {

    @Test
    public void sequenceFindTest() {
        final String[] array = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        final String value = "six";
        Finder<String> finder = new Finder<>();
        int result = finder.find(array, value);

        assertThat(result, is(5));
    }

    @Test
    public void parallelFindTest() {
        final String[] array = {
                "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
                "twenty", "twenty-one", "twenty-two"};
        final String value = "ten";
        Finder<String> finder = new Finder<>();
        int result = finder.find(array, value);

        assertThat(result, is(9));

    }

}