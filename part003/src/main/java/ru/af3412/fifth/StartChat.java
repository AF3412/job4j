package ru.af3412.fifth;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Filatov Alexander
 * @since 24.09.2016
 */
public class StartChat {

    public static void main(String[] args) throws IOException {

        Chat chat = new Chat();
        chat.start(new File("data\\file.txt"), new File("data\\output.txt"));





    }

}
