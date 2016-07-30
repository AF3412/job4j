package ru.af3412;

public class Calculator {         
	
	public double result;
	
	public void add(double first, double second){
		this.result = first + second;
	}

	public void substruct(double first, double second){
		this.result = first - second;
	}
	
	public void div(double first, double second){
		this.result = first / second;
	}

	public void multiple(double first, double second){
		this.result = first * second;
	}

	public void printResult(){
		System.out.println(this.result);	
	}      

}
