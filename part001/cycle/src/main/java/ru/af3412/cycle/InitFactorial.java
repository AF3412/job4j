package af3412;

/**
 * The type Init factorial.
 */
public class InitFactorial{

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
		int value = 6;
		Factorial fact = new Factorial(value);
		System.out.println("Factorial " + value + " = " + fact.calculate());
	}

}