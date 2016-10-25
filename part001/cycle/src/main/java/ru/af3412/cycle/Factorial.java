package af3412;

/**
 * The type Factorial.
 */
public class Factorial{

    /**
     * The Value.
     */
    int value;

    /**
     * Instantiates a new Factorial.
     *
     * @param value the value
     */
    public Factorial(int value){
			this.value = value;
		}

    /**
     * Calculate int.
     *
     * @return the int
     */
    int calculate(){
			int result = 1;
			if (value != 0)
				for (int index = 1; index <= value; index++){
					result = result * index;
			}
			return result;
		}

}