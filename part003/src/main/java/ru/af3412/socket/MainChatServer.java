package ru.af3412.socket;

import java.io.File;
import java.io.IOException;

/**
 * The type Main chat server.
 *
 * @author Filatov Alexander
 * @since 29.09.2016
 */
public class MainChatServer {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        ChatServer chatServer = new ChatServer();
        chatServer.start(new File("data\\file.txt"));

    }

}
