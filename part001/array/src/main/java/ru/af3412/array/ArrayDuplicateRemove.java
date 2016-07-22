package af3412;

public class ArrayDuplicateRemove{

	String[] array;

/*
	Constructor
*/
	public ArrayDuplicateRemove(String[] array){
		this.array = array;
	}

	/*
	Print Array method
*/
	public void printArray(){
		for(String index : array){
			System.out.print(index + " ");
		}
		System.out.println();
	}

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