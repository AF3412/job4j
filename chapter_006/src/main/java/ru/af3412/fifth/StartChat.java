package ru.af3412.fifth;

import java.io.File;
import java.io.IOException;

/**
 * The type Start chat.
 *
 * @author Filatov Alexander
 * @since 24.09.2016
 */
public class StartChat {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {

        Chat chat = new Chat();
        chat.start(new File("data\\file.txt"), new File("data\\output.txt"));


    }

}
