package ru.af3412;

/**
 * The type Two arrays.
 *
 * @author Filatov Alexander
 * @since 12.10.2016
 */
public class TwoArrays {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int[] arrayFirst = {1,2,12}; //первый массив
        int[] arraySecond = {3,4,8}; //второй массив
        int[] arrayResult = new int[arrayFirst.length + arraySecond.length]; //итоговый массив

        int indexOne = 0; //индекс первого массива
        int indexTwo = 0; //индекс второго массива
        int indexResult = 0; //индекс итогового массива

        /**
         * Сравниваем элементы двух массивов и наименьший записываем в итоговый массив.
         *  В том массиве, где найден наименьший элемент двигаемся на один элемент вперед,
         *  до тех пор пока не достигнем конца массива
         */
        while ((indexOne < arrayFirst.length) && (indexTwo < arraySecond.length)) {

                if (arrayFirst[indexOne] < (arraySecond[indexTwo])) {
                    arrayResult[indexResult] = arrayFirst[indexOne];
                    indexOne++;
                } else {
                    arrayResult[indexResult] = arraySecond[indexTwo];
                    indexTwo++;
                }

            indexResult++;

        }

        /**
         * В итоге у нас один начальный массив полностью переписан в итоговый массив.
         * Остается только остаток второго массива записать в итоговый.
         */
        while (indexResult < arrayResult.length) {
            if (indexOne < arrayFirst.length) {
                arrayResult[indexResult] = arrayFirst[indexOne];
                indexOne++;
                indexResult++;
            }
            else {
                arrayResult[indexResult] = arraySecond[indexTwo];
                indexTwo++;
                indexResult++;
            }
        }

        /**
         * Выводим результат на экран
         */
       for (int index = 0; index < arrayResult.length; index++) {
            System.out.println(arrayResult[index]);
        }

    }

}
