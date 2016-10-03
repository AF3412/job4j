package ru.af3412.socket;

import java.io.*;
import java.net.*;
import java.util.Random;

/**
 * @author Filatov Alexander
 * @since 28.09.2016
 */
public class ChatServer {

    private final Random rnd = new Random(System.currentTimeMillis());

    private final int serverPort = 4444;

    boolean stop = false;

    BufferedReader in = null;
    PrintWriter out = null;

    ServerSocket serverSocket = null;
    Socket fromClient = null;

    public void start(File file) throws IOException {

        String[] arrayString = returnArrayStringFromFile(file);

        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for a client...");
            fromClient = serverSocket.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(-1);
        }

        try {
            in = new BufferedReader(new InputStreamReader(fromClient.getInputStream()));
            out = new PrintWriter(fromClient.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("IO error");
        }

        String input, output;

        try {
            System.out.println("Wait for messages");
            while ((input = in.readLine()) != null) {
                if (input.equals("выход")) break;
                if (input.equals("стоп")) stop = true;
                if (input.equals("продолжить")) stop = false;
                System.out.println(stop);
                if (!stop) {
                    out.println(getRandomString(arrayString));
                } else {
                    out.println();
                }
                System.out.println(input);
            }
        } catch (IOException e) {
            System.out.println("IO error");
            System.exit(-1);
        }

        try {
            out.close();
            in.close();
            fromClient.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("IO error");
            System.exit(-1);
        }

    }

    public String[] returnArrayStringFromFile(File readFile) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader(readFile));
        StringBuilder sb = new StringBuilder();
        String line;

        try {
            while ((line = file.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        line = sb.toString();
        return (line.split("\n"));
    }

    public String getRandomString(String[] string) {
        return string[rnd.nextInt(string.length)];
    }

}
