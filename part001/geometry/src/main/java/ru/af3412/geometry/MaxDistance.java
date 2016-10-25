package af3412;

/**
 * The type Max distance.
 */
public class MaxDistance{

    /**
     * The First value.
     */
    double firstValue;
    /**
     * The Second value.
     */
    double secondValue;

    /**
     * Instantiates a new Max distance.
     *
     * @param first  the first
     * @param second the second
     */
    public MaxDistance(double first, double second){
		this.firstValue = first;
		this.secondValue = second;
	}

    /**
     * Max double.
     *
     * @return the double
     */
    public double max(){
		double returnValue; //не создавать!!! делать return firstValue > secondValue ? firstValue : secondValue;
		returnValue = firstValue > secondValue ? firstValue : secondValue;
		return returnValue;
	}
		
}