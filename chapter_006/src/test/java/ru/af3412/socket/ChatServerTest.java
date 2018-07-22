package ru.af3412.socket;

import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The type Chat server test.
 *
 * @author Filatov Alexander
 * @since 04.10.2016
 */
public class ChatServerTest {
    /**
     * Start.
     *
     * @throws Exception the exception
     */
    @Test
    public void start() throws Exception {

    }

    /**
     * Test return array string from file.
     *
     * @throws Exception the exception
     */
    @Test
    public void testReturnArrayStringFromFile() throws Exception {

        File file = new File("..\\data\\test\\chat_readFileToArrayString.txt");
        ChatServer chat = new ChatServer();
        String[] valueArrayString = {"1", "2", "3", "4", "5"};

        String[] testString = chat.returnArrayStringFromFile(file);

        assertThat(valueArrayString, is(testString));

    }

    /**
     * Test get random string.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetRandomString() throws Exception {

        ChatServer rnd = mock(ChatServer.class);
        String[] valueArrayString = {"1", "2", "3", "4", "5"};
        when(rnd.getRandomString(valueArrayString)).thenReturn("1");
        String valueString = "1";

        String result = rnd.getRandomString(valueArrayString);

        assertThat(valueString, is(result));

    }

}