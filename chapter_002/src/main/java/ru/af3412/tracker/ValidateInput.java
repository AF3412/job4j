package ru.af3412.tracker;

/**
 * The type Validate input.
 */
public class ValidateInput extends ConsoleInput {

    public int ask(String question, int[] range) {

        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again");
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            }
        } while (invalid);
        return value;
    }

}