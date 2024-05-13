package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class GameClient {
    public static void main(String[] args) {
        String serverHostname = "localhost";
        int port = 12345;

        //ma conectez la server si citesc mesaje ca input si le trimit la server pana ii trimit exit (bye bye)
        try (
                Socket socket = new Socket(serverHostname, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to the server. ('exit' to quit)");

            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null)
            {
                if (userInputLine.equals("exit"))
                {
                    break;
                }
                out.println(userInputLine);
                String response = in.readLine();
                System.out.println("Server response : " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
