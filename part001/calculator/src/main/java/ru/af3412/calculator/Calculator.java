package ru.af3412.calculator;

/**
 * The type Calculator.
 */
public class Calculator {

    /**
     * The Result.
     */
    public double result;

    /**
     * Add.
     *
     * @param first  the first
     * @param second the second
     */
    public void add(double first, double second){
		this.result = first + second;
	}

    /**
     * Substruct.
     *
     * @param first  the first
     * @param second the second
     */
    public void substruct(double first, double second){
		this.result = first - second;
	}

    /**
     * Div.
     *
     * @param first  the first
     * @param second the second
     */
    public void div(double first, double second){
		this.result = first / second;
	}

    /**
     * Multiple.
     *
     * @param first  the first
     * @param second the second
     */
    public void multiple(double first, double second){
		this.result = first * second;
	}

    /**
     * Print result.
     */
    public void printResult(){
		System.out.println(this.result);	
	}      

}
