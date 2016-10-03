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

    public void start() throws IOException {


        System.out.println("Welcome to Client side");

        fromserver = new Socket(IPAddress, 4444);
        BufferedReader in = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
        PrintWriter out = new PrintWriter(fromserver.getOutputStream(), true);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        String fuser, fserver;

        while ((fuser = inu.readLine()) != null) {
            out.println(fuser);
            fserver = in.readLine();
            System.out.println(fserver);
            if (fuser.equalsIgnoreCase("выход")) break;
        }

        out.close();
        in.close();
        inu.close();
        fromserver.close();
    }
}
