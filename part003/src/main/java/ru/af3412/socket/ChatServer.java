package ru.af3412.socket;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 * @author Filatov Alexander
 * @since 28.09.2016
 * this class get random answers from file
 */
public class ChatServer {

    /**
     * @param rnd return random int
     * @param serverPort listen net port
     */
    private Random rnd = new Random(System.currentTimeMillis());
    private int serverPort = 4444;

    /**
     * This method received a message from the client and sends a random string
     *
     * @param file get file for answers
     * @param arrayString is an array of string from a file
     * @param in get values from the client
     * @param out return random string from file to client
     * @param serverSocket initializing server port
     * @param fromClient listened server socket
     * @throws IOException
     */
    public void start(File file) throws IOException {

        String[] arrayString = returnArrayStringFromFile(file);
        boolean stop = false;
        String input;

        try (ServerSocket serverSocket = new ServerSocket(serverPort);
             Socket fromClient = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(fromClient.getInputStream()));
             PrintWriter out = new PrintWriter(fromClient.getOutputStream(), true)
        ) {
            System.out.println("Wait for messages");
            while ((input = in.readLine()) != null) {
                if (input.equals("выход")) break;
                if (input.equals("стоп")) stop = true;
                if (input.equals("продолжить")) stop = false;
                if (!stop) {
                    out.println(getRandomString(arrayString));
                } else {
                    out.println();
                }
            }
        } catch (IOException e) {
            System.out.println("IO error");
        }

    }

    /**
     * @param readFile get file for answers
     * @return array of string from a file
     * @throws IOException
     */
    protected String[] returnArrayStringFromFile(File readFile) throws IOException {

        StringBuilder sb = new StringBuilder();
        String line;

        try (BufferedReader file = new BufferedReader(new FileReader(readFile))) {
            while ((line = file.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        line = sb.toString();
        return (line.split("\n"));
    }

    /**
     * @param string is array string from file
     * @return random string
     */
    protected String getRandomString(String[] string) {
        return string[rnd.nextInt(string.length)];
    }

}
