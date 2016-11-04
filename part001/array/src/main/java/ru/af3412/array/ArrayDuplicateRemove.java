package af3412;

/**
 * The type Array duplicate remove.
 */
public class ArrayDuplicateRemove{

    /**
     * The Array.
     */
    String[] array;

    /**
     * Instantiates a new Array duplicate remove.
     *
     * @param array the array
     */
/*
    Constructor
*/
	public ArrayDuplicateRemove(String[] array){
		this.array = array;
	}

    /**
     * Print array.
     */
/*
    Print Array method
*/
	public void printArray(){
		for(String index : array){
			System.out.print(index + " ");
		}
		System.out.println();
	}

    /**
     * Remove duplicate.
     */
    public void removeDuplicate(){
		for(int indexA=0; indexA != array.length; indexA++){
			if (array[indexA] != null){
				for(int indexB = indexA + 1; indexB != array.length; indexB++){
					if (array[indexB] != null){
							if (array[indexB].equals(array[indexA]))
								array[indexB] = null;
					}		
				}
			}	
		}
		//moveDuplicate
		for(int indexA=0; indexA != array.length; indexA++){
			if(array[indexA] == null) 
				for(int indexB = indexA + 1; indexB != array.length; indexB++){
					if(array[indexB] != null){
						String temp = array[indexB];
						array[indexB] = array[indexA];
						array[indexA] = temp;
						break;
					}
			}
		}
	}

}