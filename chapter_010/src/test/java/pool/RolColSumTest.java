package pool;

import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class RolColSumTest {


    private static final int[][] MATRIX = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    @Test
    public void whenSumMatrixThenReturnCorrectSum() {
        RolColSum.Sums[] result = RolColSum.sum(MATRIX);
        assertThat(result[0].rowSum, is(6));
        assertThat(result[0].colSum, is(12));
        assertThat(result[1].rowSum, is(15));
        assertThat(result[1].colSum, is(15));
        assertThat(result[2].rowSum, is(24));
        assertThat(result[2].colSum, is(18));
    }

    @Test
    public void whenAsyncSumMatrixThenReturnCorrectSum() throws ExecutionException, InterruptedException {
        RolColSum.Sums[] result = RolColSum.asyncSum(MATRIX);
        assertThat(result[0].rowSum, is(6));
        assertThat(result[0].colSum, is(12));
        assertThat(result[1].rowSum, is(15));
        assertThat(result[1].colSum, is(15));
        assertThat(result[2].rowSum, is(24));
        assertThat(result[2].colSum, is(18));
    }
}