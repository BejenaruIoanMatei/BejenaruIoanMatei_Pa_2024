package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    private ServerSocket serverSocket;
    private boolean running;

    // partea de server cu ServerSocket
    public GameServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
            running = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //partea de thread uri pentru fiecare client separat
    public void start() {
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

                // aici se face thread ul
                ClientThread clientThread = new ClientThread(clientSocket);
                clientThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        try {
            running = false;
            serverSocket.close();
            System.out.println("Server stopped");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 12345;
        GameServer gameServer = new GameServer(port);
        gameServer.start();
    }
}
