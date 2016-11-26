package ru.af3412.srp;

/**
 * The type Interact calc.
 *
 * @author Filatov Alexander
 * @since 29.10.2016
 */
public class InteractCalc {

    /**
     * The Input.
     */
    private Input input = new Input();
    /**
     * The Validator.
     */
    private Validator validator = new Validator();
    /**
     * The Calculator.
     */
    private Calculator calculator = new Calculator();

    /**
     * Start.
     */
    public void start() {

        double first;
        double second;
        String operation;
        double result;
        String userInput;

        do {
            first = numberInput();
            do {
                operation = mathOperationInput();
                second = numberInput();
                result = calculator.calculate(first, operation, second);
                System.out.printf("Result: %s, \n", result);
                userInput = input.in("Continue? (y/n): ");
                if (userInput.equals("y")) {
                    first = result;
                }
            } while (!userInput.equals("n"));

            userInput = input.in("Exit? (y/n): ");
        } while (!userInput.equals("y"));

    }

    /**
     * Number input double.
     *
     * @return the double
     */
    public double numberInput() {

        String userInput;
        double value = 0;

        do {
            userInput = input.in("Enter value: ");
            if (validator.checkNumber(userInput)) {
                value = validator.convertStringToDouble(userInput);
            } else {
                System.out.println("Incorrect value, please repeat");
            }

        } while (!validator.checkNumber(userInput));

        return value;

    }

    /**
     * Math operation input string.
     *
     * @return the string
     */
    protected String mathOperationInput() {

        String userInput;
        String value = "";

        do {
            userInput = input.in("Enter operation: ");
            if (validator.checkMathOperation(userInput)) {
                value = userInput;
            } else {
                System.out.println("Incorrect value, please repeat");
            }

        } while (validator.checkNumber(userInput));

        return value;

    }

}
