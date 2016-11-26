package ru.af3412.ocp;


import ru.af3412.srp.Input;
import ru.af3412.srp.InteractCalc;

/**
 * The type Interact calc trig.
 *
 * @author Filatov Alexander
 * @since 08.11.2016
 */
public class InteractCalcTrig extends InteractCalc {

    /**
     * The Calculator.
     */
    private CalculatorTrig calculator = new CalculatorTrig();

    /**
     * The Validator.
     */
    private ValidatorTrig validator = new ValidatorTrig();

    /**
     * The Input.
     */
    private Input input = new Input();

    /**
     * Override method logic().
     * add check input trigonometry operation
     */

    @Override
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
                if (validator.checkTrigMathOperation(operation)) {
                    result = calculator.calculate(first, operation);
                } else {
                    second = numberInput();
                    result = calculator.calculate(first, operation, second);
                }
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
     * Override method mathOperationInput().
     * add check input trigonometry operation
     */
    @Override
    protected String mathOperationInput() {
        String userInput;
        String value = "";

        do {
            userInput = input.in("Enter operation: ");
            if (validator.checkMathOperation(userInput) || (validator.checkTrigMathOperation(userInput))) {
                value = userInput;
            } else {
                System.out.println("Incorrect value, please repeat");
            }

        } while (validator.checkNumber(userInput));

        return value;
    }
}
