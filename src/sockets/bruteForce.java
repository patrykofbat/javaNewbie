package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class bruteForce {
    Socket echoSocket = null;
    PrintWriter out = null;
    BufferedReader in = null;


    public void connect() throws IOException {
        try {
            echoSocket = new Socket("szymon.ia.agh.edu.pl", 3000);
            out = new PrintWriter(echoSocket.getOutputStream(), true); //
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
//            System.out.println(echoSocket.getRemoteSocketAddress());
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        System.out.println("Type a message: ");


        out.println("LOGIN"); // GET /url HTTP/1.1
        out.println("patryk;papior");
        out.println("Host: szymon.ia.agh.edu.pl"); //DOMENA HOST
        out.println("");
        out.flush();
        while (in.readLine() != null)
            System.out.println("echo: " + in.readLine());


        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}

