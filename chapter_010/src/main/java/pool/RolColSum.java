package pool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RolColSum {

    public static class Sums {
        int rowSum;
        int colSum;

        public Sums(int rowSum, int colSum) {
            this.rowSum = rowSum;
            this.colSum = colSum;
        }
    }


    /**
     * Последовательный код. Считает сумму в столбце и строке,
     * записывает сумму элементов по i строке и i столбцу в класс Sums;
    * */
    public static Sums[] sum(int[][] matrix) {
        Sums[] result = new Sums[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int[] col = getColumn(matrix, i);
            result[i] = new Sums(getArraySum(row), getArraySum(col));
        }
        return result;
    }


    /**
     * Параллельный код. Считает сумму в столбце и строке параллельно,
     * записывает сумму элементов по i строке и i столбцу в класс Sums;
    * */
    public static Sums[] asyncSum(int[][] matrix) throws ExecutionException, InterruptedException {
        Sums[] result = new Sums[matrix.length];
        Map<Integer, CompletableFuture<Sums>> futures = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            futures.put(i, getTask(matrix, i));
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = futures.get(i).get();
        }
        return result;
    }

    /**
     * Возвращает массив со значением колонки номер "column"
     */
    private static int[] getColumn(int[][] matrix, int column) {
        return Arrays.stream(matrix)
                .mapToInt(values -> values[column])
                .toArray();
    }

    private static int getArraySum(int[] array) {
        return Arrays.stream(array).sum();
    }

    private static CompletableFuture<Sums> getTask(int[][] matrix, int index) {
        return CompletableFuture.supplyAsync(() -> {
            int[] row = matrix[index];
            int[] col = getColumn(matrix, index);
            return new Sums(getArraySum(row), getArraySum(col));
        });

    }

}
