package af3412;

public class ArrayBubbleSort{
	
	int[] array;

/*
	Constructor
*/
	public ArrayBubbleSort(int[] array){
		this.array = array;
	}

/*
	Print Array method
*/
	public void printArray(){
		for(int index : array){
			System.out.print(index + " ");
		}
		System.out.println();
	}

/*
	Sort Array method
*/
	public int[] bubbleSort(){
		for(int indexA=1; indexA < array.length; indexA++){
			for(int indexB=array.length-1; indexB>= indexA; indexB--){
				if (array[indexB-1] > array[indexB]) {
					int temp = array[indexB-1];
					array[indexB-1] = array[indexB];
					array[indexB] = temp;
				}
			}
		}
		return array;
	}

}

