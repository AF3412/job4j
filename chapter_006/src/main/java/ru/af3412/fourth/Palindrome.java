package ru.af3412.fourth;

/**
 * Class checks whether the word of five letters entered by the user, a palindrome
 *
 * @author Filatov Alexander
 * @since 18.09.2016
 */
public class Palindrome {

    /**
     * Check word palindrome boolean.
     *
     * @param text takes the word
     * @return boolean value palindrome or not
     */
    public boolean checkWordPalindrome(String text) {
        boolean checkPalindrome = true;
        char[] chText = text.toCharArray();
        for (int index = 0; index < chText.length / 2; index++) {
            if (chText[index] != chText[chText.length - index - 1]) {
                checkPalindrome = false;
                break;
            }
        }
        return (checkPalindrome);
    }

    /**
     * Check five lower word palindrome string.
     *
     * @param text takes the word
     * @return result(check five letters or not palindrome or not) string
     */
    public String checkFiveLowerWordPalindrome(String text) {
        text = text.toLowerCase();
        String result;
        if (text.length() == 5) {
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
