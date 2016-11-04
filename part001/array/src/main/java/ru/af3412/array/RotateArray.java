package af3412;

/**
 * The type Rotate array.
 */
public class RotateArray{

    /**
     * The Array.
     */
    int[][] array;

    /**
     * Instantiates a new Rotate array.
     *
     * @param array the array
     */
/*
    Constructor
*/
	public RotateArray(int[][] array){
		this.array = array;
	}

    /**
     * Print two array.
     */
/*
    print array
*/
	public void printTwoArray(){
		for(int indexA = 0; indexA < array.length; indexA++){
			for(int indexB = 0; indexB < array.length; indexB++){
				System.out.print(array[indexA][indexB] + " ");
			}
			System.out.println();
		}
	}

    /**
     * Rotate.
     */
/*
    rotate array
*/
	public void rotate(){
		int[][] tempArray = new int[array.length][array.length];
		for(int indexA = 0; indexA < array.length; indexA++){
			for(int indexB = 0; indexB < array.length; indexB++){
				tempArray[indexB][array.length - indexA - 1] = array[indexA][indexB];	
			}
		}
		array = tempArray;
		tempArray = null;

	}

}