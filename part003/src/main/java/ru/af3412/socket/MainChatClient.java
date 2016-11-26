package ru.af3412.socket;

import java.io.File;
import java.io.IOException;

/**
 * The type Main chat client.
 *
 * @author Filatov Alexander
 * @since 29.09.2016
 */
public class MainChatClient {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        ChatClient chatClient = new ChatClient();
        chatClient.start(new File("data\\outSocket.txt"));

    }
}
