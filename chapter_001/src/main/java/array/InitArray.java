package array;

/**
 * The type Init array.
 */
public class InitArray {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

/*
        First task
*/
        System.out.println("\t First task \n");
        int[] arrayFirst = {2, 1};

//		ArrayBubbleSort array = new ArrayBubbleSort(new int[]{1, 2, 3, 5, 7, 9, 2, 4, -88, 0});
        ArrayBubbleSort arrayF = new ArrayBubbleSort(arrayFirst);
        arrayF.printArray();
        int[] arrayN = arrayF.bubbleSort();
        arrayF.printArray();
        System.out.println();

/*
		Second task
*/
        System.out.println("\t Second task \n");

        int[][] arraySecond = {
                {1, 2},
                {3, 4}
        };

        RotateArray arrayS = new RotateArray(arraySecond);
        arrayS.printTwoArray();
        arrayS.rotate();
        System.out.println();
        arrayS.printTwoArray();
        System.out.println();

/*
		Third task
*/
        System.out.println("\t Third task \n");

        String[] arrayThird = {"a", "a"};

        ArrayDuplicateRemove arrayT = new ArrayDuplicateRemove(arrayThird);
        arrayT.printArray();
        arrayT.removeDuplicate();
        arrayT.printArray();

    }
}