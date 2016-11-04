package ru.af3412.socket;

import java.net.*;
import java.io.*;

/**
 * The type Chat client.
 *
 * @author Filatov Alexander
 * @since 29.09.2016 This class - the client to the server sends requests and receives responses writes the values in the file
 */
public class ChatClient {

    /**
     * The Ip address.
     *
     * @param IPAddress is server IP address
     * @param fromServer is server socket
     * @param in is stream from server
     * @param out is stream to server
     * @param inUser gets the keyboard input
     */
    String ipAddress = "127.0.0.1";
    /**
     * The Socket port.
     */
    int socketPort = 4444;

    /**
     * This method sends the data to the server, receives a response, and writes a log file
     *
     * @param fileOut is a log file
     * @throws IOException the io exception
     */
    public void start(File fileOut) throws IOException {

        try (Socket fromServer = new Socket(ipAddress, socketPort);
             BufferedReader in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
             BufferedReader inUser = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(fromServer.getOutputStream(), true)
            ) {

            PrintWriter pw = new PrintWriter(fileOut);
            StringBuilder sb = new StringBuilder();

            System.out.println("Welcome to Client side");

            String fuser, fserver;

            while ((fuser = inUser.readLine()) != null) {
                sb.append(fuser).append("\n");
                out.println(fuser);
                fserver = in.readLine();
                sb.append(fserver).append("\n");
                pw.println(sb.toString());
                sb.delete(0, sb.length());
                System.out.println(fserver);
                if (fuser.equalsIgnoreCase("выход")) break;
            }

            pw.flush();

        } catch (IOException ex) {
            System.out.println("IO exception");
        }

    }

}
