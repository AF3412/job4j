package af3412;

public class InitFactorial{

	public static void main(String[] args) {
		int value = 6;
		Factorial fact = new Factorial(value);
		System.out.println("Factorial " + value + " = " + fact.calculate());
	}

}