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
    public void whenInpunStringCheckIsFiveLetters() {

        Palindrome palindrome = new Palindrome();
        String textOne = "55555";
        String textTwo = "";
        boolean checkFiveOne;
        boolean checkFiveTwo;

        checkFiveOne = palindrome.checkFiveLetters(textOne);
        checkFiveTwo = palindrome.checkFiveLetters(textTwo);

        assertTrue(checkFiveOne);
        assertFalse(checkFiveTwo);
    }

    @Test
    public void whenInputStringThenConvertStringToLowerCase() {
        Palindrome palindrome = new Palindrome();
        String textOne = "Test";
        String checkText = "test";
        String testText;

        testText = palindrome.lowerCase(textOne);

        assertThat(testText, is(checkText));
    }

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