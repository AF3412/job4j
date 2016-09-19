package ru.af3412.fourth;

/**
 * Class checks whether the word of five letters entered by the user, a palindrome
 *
 * @author Filatov Alexander
 * @since 18.09.2016
 */
public class Palindrome {

    /**
     * @param text takes the word
     * @return boolean value of five letters or not
     */
    public boolean checkFiveLetters(String text) {
        return (text.length() == 5);
    }

    /**
     * @param text takes the word
     * @return formatted word lowercase
     */
    public String lowerCase(String text) {
        return (text.toLowerCase());
    }

    /**
     * @param text takes the word
     * @return boolean value palindrome or not
     */
    public boolean checkWordPalindrome(String text) {
        text = lowerCase(text);
        return (text.equals(new StringBuffer(text).reverse().toString()));

    }

    /**
     * @param text takes the word
     * @return result(check five letters or not; palindrome or not)
     */
    public String checkFiveLowerWordPalindrome(String text) {
        String result;
        if (checkFiveLetters(text)) {
            if (checkWordPalindrome(text)) {
                result = "Word is a palindrome";
            } else {
                result = "Word isn't a palindrome";
            }

        } else {
            result = "Not five letters";
        }
        return result;
    }
}
