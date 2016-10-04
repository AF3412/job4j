package ru.af3412.socket;

import java.net.*;
import java.io.*;

/**
 * @author Filatov Alexander
 * @since 29.09.2016
 */

public class ChatClient {

    Socket fromserver = null;
    String IPAddress = "127.0.0.1";
    BufferedReader in;
    PrintWriter out;
    BufferedReader inUser;

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
        fromserver.close();
    }

    public void init() throws IOException {

        this.fromserver = new Socket(IPAddress, 4444);
        this.in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        this.out = new PrintWriter(fromserver.getOutputStream(), true);
        this.inUser = new BufferedReader(new InputStreamReader(System.in));

    }
}
