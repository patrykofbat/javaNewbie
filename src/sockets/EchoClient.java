package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    private Socket connection;
    private PrintWriter out;
    private BufferedReader in;
    private String host;
    private int port;

    EchoClient(String host, int port){
        this.host = host;
        this.port = port;

    }

    public void EchoUserInput() throws IOException{
        try {
            connection = new Socket(host, port);
            out = new PrintWriter(connection.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("Message: ");
        while ( stdIn.readLine() != null) {
//            out.println(stdIn.readLine());
            System.out.println(stdIn.readLine());
            System.out.println(in.readLine());
        }
        out.close();
        in.close();
        stdIn.close();
        connection.close();
    }
}
