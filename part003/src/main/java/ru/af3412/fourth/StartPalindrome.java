package ru.af3412.fourth;

import java.util.Scanner;

/**
 * Start class Palindrome
 *
 * @author Filatov Alexander
 * @since 19.09.2016
 */
public class StartPalindrome {

    public static void main(String[] args) {

        /**
         * word is checked word entered from the keyboard
         */
        String word;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter word: ");
        word = scanner.nextLine(); //input word

        /**
         * Starts class "Palindrome" and outputs the result
         */
        System.out.println(new Palindrome().checkFiveLowerWordPalindrome(word));

    }

}
