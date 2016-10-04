package ru.af3412.socket;

import java.net.*;
import java.io.*;

/**
 * @author Filatov Alexander
 * @since 29.09.2016
 * This class - the client to the server sends requests and receives responses writes the values in the file
 */

public class ChatClient {

    /**
     * @param IPAddress is server IP address
     * @param fromServer is server socket
     * @param in is stream from server
     * @param out is stream to server
     * @param inUser gets the keyboard input
     */

    String IPAddress;
    Socket fromServer = null;
    BufferedReader in;
    PrintWriter out;
    BufferedReader inUser;

    /**
     * This method sends the data to the server, receives a response, and writes a log file
     *
     * @param fileOut is a log file
     * @throws IOException
     */

    public void start(File fileOut) throws IOException {

        this.init();

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
        pw.close();
        out.close();
        in.close();
        inUser.close();
        fromServer.close();
    }

    /**
     * This method initializes the start values
     *
     * @throws IOException
     */
    public void init() throws IOException {

        this.IPAddress = "127.0.0.1";
        this.fromServer = new Socket(IPAddress, 4444);
        this.in = new BufferedReader(new InputStreamReader(fromServer.getInputStream()));
        this.out = new PrintWriter(fromServer.getOutputStream(), true);
        this.inUser = new BufferedReader(new InputStreamReader(System.in));

    }
}
