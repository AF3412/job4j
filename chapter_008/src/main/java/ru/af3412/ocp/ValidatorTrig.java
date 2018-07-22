package ru.af3412.ocp;

import ru.af3412.srp.Validator;

/**
 * The type Validator trig.
 *
 * @author Filatov Alexander
 * @since 08.11.2016
 */
public class ValidatorTrig extends Validator {

    /**
     * Check trigonometry math operation.
     *
     * @param args the args
     * @return the boolean
     */
    public boolean checkTrigMathOperation(String args) {
        boolean result = false;
        if ((args.equals("sin")) || (args.equals("cos")) || (args.equals("tan"))) {
            result = true;
        }

        return result;
    }

}
