package ru.af3412.fourth;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Filatov Alexander
 * @since 18.09.2016
 */
public class PalindromeTest {


    @Test
    public void checkPalindromeClass() {
        Palindrome palindrome = new Palindrome();
        String textOne = "kokok";
        String textTwo = "koko";
        boolean testPalindromeOne;
        boolean testPalindromeTwo;

        testPalindromeOne = palindrome.checkWordPalindrome(textOne);
        testPalindromeTwo = palindrome.checkWordPalindrome(textTwo);

        assertTrue(testPalindromeOne);
        assertFalse(testPalindromeTwo);

    }

    @Test
    public void checkStartPalindromeClass() {
        Palindrome palindrome = new Palindrome();
        String textOne = "KoKoK";
        String textResultOne;
        String textCheckResultOne = "Word is a palindrome";
        String textTwo = "K";
        String textResultTwo;
        String textCheckResultTwo = "Not five letters";
        String textThree = "Kikok";
        String textResultThree;
        String textCheckResultThree = "Word isn't a palindrome";

        textResultOne = palindrome.checkFiveLowerWordPalindrome(textOne);
        textResultTwo = palindrome.checkFiveLowerWordPalindrome(textTwo);
        textResultThree = palindrome.checkFiveLowerWordPalindrome(textThree);


        assertThat(textResultOne, is(textCheckResultOne));
        assertThat(textResultTwo, is(textCheckResultTwo));
        assertThat(textResultThree, is(textCheckResultThree));

    }

}