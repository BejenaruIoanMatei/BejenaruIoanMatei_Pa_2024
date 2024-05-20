package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private GameServer server;

    public ClientThread(Socket socket, GameServer server) {
        this.clientSocket = socket;
        this.server = server;
        try {
            this.out = new PrintWriter(clientSocket.getOutputStream(), true);
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String request;
        try {
            while ((request = in.readLine()) != null) {
                System.out.println("Received request: " + request);
                String response = handleRequest(request);
                out.println(response);
                if (request.equalsIgnoreCase("stop")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String handleRequest(String request) {
        String[] parts = request.split(" ");
        String command = parts[0];
        switch (command) {
            case "create":
                int gameId = server.createGame();
                return "Game created with ID: " + gameId;
            case "join":
                if (parts.length < 3) {
                    return "Invalid command";
                }
                int joinGameId = Integer.parseInt(parts[1]);
                String playerName = parts[2];
                Game game = server.getGame(joinGameId);
                if (game != null && game.addPlayer(playerName)) {
                    if (game.startGame()) {
                        return "Player " + playerName + " joined game " + joinGameId + ". Game started!";
                    }
                    return "Player " + playerName + " joined game " + joinGameId;
                }
                return "Could not join game";
            case "move":
                if (parts.length < 4) {
                    return "Invalid command";
                }
                int moveGameId = Integer.parseInt(parts[1]);
                String movePlayerName = parts[2];
                int x = Integer.parseInt(parts[3]);
                int y = Integer.parseInt(parts[4]);
                Game moveGame = server.getGame(moveGameId);
                if (moveGame != null) {
                    return moveGame.submitMove(movePlayerName, x, y);
                }
                return "Game not found";
            case "print":
                int printGameId = Integer.parseInt(parts[1]);
                Game printGame = server.getGame(printGameId);
                if (printGame != null) {
                    printGame.printBoards();
                    return "Printed game board for game ID: " + printGameId;
                }
                return "Game not found";
            case "stop":
                server.stop();
                return "Server stopped";
            default:
                return "Unknown command";
        }
    }
}
