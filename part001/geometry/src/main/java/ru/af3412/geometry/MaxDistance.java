package af3412;

public class MaxDistance{

	double firstValue;
	double secondValue;

	public MaxDistance(double first, double second){
		this.firstValue = first;
		this.secondValue = second;
	}

	public double max(){
		double returnValue; //не создавать!!! делать return firstValue > secondValue ? firstValue : secondValue;
		returnValue = firstValue > secondValue ? firstValue : secondValue;
		return returnValue;
	}
		
}