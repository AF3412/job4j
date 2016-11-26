package ru.af3412.srp;

import java.util.Scanner;

/**
 * The type Input.
 *
 * @author Filatov Alexander
 * @since 31.10.2016
 */
public class Input {


    /**
     * The scanner for input.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * In string.
     *
     * @param question the question
     * @return the string
     */
    public String in(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

}