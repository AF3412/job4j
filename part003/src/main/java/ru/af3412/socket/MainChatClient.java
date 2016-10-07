package ru.af3412.socket;

import java.io.File;
import java.io.IOException;

/**
 * @author Filatov Alexander
 * @since 29.09.2016
 */
public class MainChatClient {

    public static void main(String[] args) throws IOException {

        ChatClient chatClient = new ChatClient();
        chatClient.start(new File("data\\outSocket.txt"));

    }
}
