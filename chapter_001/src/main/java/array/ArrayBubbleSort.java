package array;

/**
 * The type Array bubble sort.
 */
public class ArrayBubbleSort {

    /**
     * The Array.
     */
    int[] array;

    /**
     * Instantiates a new Array bubble sort.
     *
     * @param array the array
     */
/*
    Constructor
*/
    public ArrayBubbleSort(int[] array) {
        this.array = array;
    }

    /**
     * Print array.
     */
/*
    Print Array method
*/
    public void printArray() {
        for (int index : array) {
            System.out.print(index + " ");
        }
        System.out.println();
    }

    /**
     * Bubble sort int [ ].
     *
     * @return the int [ ]
     */
/*
    Sort Array method
*/
    public int[] bubbleSort() {
        for (int indexA = 1; indexA < array.length; indexA++) {
            for (int indexB = array.length - 1; indexB >= indexA; indexB--) {
                if (array[indexB - 1] > array[indexB]) {
                    int temp = array[indexB - 1];
                    array[indexB - 1] = array[indexB];
                    array[indexB] = temp;
                }
            }
        }
        return array;
    }

}

