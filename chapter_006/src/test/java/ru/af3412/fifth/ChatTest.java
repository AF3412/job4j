package ru.af3412.fifth;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The type Chat test.
 *
 * @author Filatov Alexander
 * @since 27.09.2016
 */
public class ChatTest {

    /**
     * Test read file to array string.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testReadFileToArrayString() throws IOException {

        File file = new File("..\\data\\test\\chat_readFileToArrayString.txt");
        Chat chat = new Chat();
        String[] valueArrayString = {"1", "2", "3", "4", "5"};

        String[] testString = chat.getArrayStringFromFile(file);

        assertThat(valueArrayString, is(testString));

    }

    /**
     * Test get random string.
     */
    @Test
    public void testGetRandomString() {
        Chat rnd = mock(Chat.class);
        String[] valueArrayString = {"1", "2", "3", "4", "5"};
        when(rnd.getRandomString(valueArrayString)).thenReturn("1");
        String valueString = "1";

        String result = rnd.getRandomString(valueArrayString);

        assertThat(valueString, is(result));

    }

}