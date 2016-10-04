package ru.af3412.socket;

import org.junit.Test;
import ru.af3412.fifth.Chat;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Filatov Alexander
 * @since 04.10.2016
 */
public class ChatServerTest {
    @Test
    public void start() throws Exception {

    }

    @Test
    public void testReturnArrayStringFromFile() throws Exception {

        File file = new File("..\\data\\test\\chat_readFileToArrayString.txt");
        Chat chat = new Chat();
        String[] valueArrayString = {"1","2","3","4","5"};

        String[] testString = chat.getArrayStringFromFile(file);

        assertThat(valueArrayString, is(testString));

    }

    @Test
    public void testGetRandomString() throws Exception {

        Chat rnd = mock(Chat.class);
        String[] valueArrayString = {"1","2","3","4","5"};
        when(rnd.getRandomString(valueArrayString)).thenReturn("1");
        String valueString = "1";

        String result = rnd.getRandomString(valueArrayString);

        assertThat(valueString, is(result));

    }

}