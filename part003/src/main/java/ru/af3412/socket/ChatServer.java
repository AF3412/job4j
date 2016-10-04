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

    private Random rnd;
    private int serverPort;
    private String[] arrayString;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private ServerSocket serverSocket = null;
    private Socket fromClient = null;

    public void start(File file) throws IOException {

        boolean stop = false;

        this.init(file);

        String input;

        try {
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

    protected void init(File file) throws IOException {

        this.arrayString = returnArrayStringFromFile(file);

        this.rnd = new Random(System.currentTimeMillis());
        this.serverPort = 4444;

        try {
            this.serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for a client...");
            this.fromClient = serverSocket.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(-1);
        }

        try {
            this.in = new BufferedReader(new InputStreamReader(fromClient.getInputStream()));
            this.out = new PrintWriter(fromClient.getOutputStream(), true);
        } catch (IOException e) {
            System.out.println("IO error");
        }

    }

    protected String[] returnArrayStringFromFile(File readFile) throws IOException {
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

    protected String getRandomString(String[] string) {
        return string[rnd.nextInt(string.length)];
    }

}
