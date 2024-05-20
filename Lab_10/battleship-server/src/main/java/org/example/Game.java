package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Game {
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);
    private final int id;
    private final Map<String, Player> players;
    private final GameBoard board1;
    private final GameBoard board2;
    private boolean gameStarted;
    private String currentPlayer;

    public Game() {
        this.id = ID_GENERATOR.getAndIncrement();
        this.players = new HashMap<>();
        this.board1 = new GameBoard();
        this.board2 = new GameBoard();
        this.gameStarted = false;
    }

    public int getId() {
        return id;
    }

    public boolean addPlayer(String playerName) {
        if (players.size() >= 2 || gameStarted) {
            return false;
        }
        Player player = new Player(playerName);
        players.put(playerName, player);
        if (players.size() == 1) {
            currentPlayer = playerName;
        }
        return true;
    }

    public boolean startGame() {
        if (players.size() == 2) {
            gameStarted = true;
            return true;
        }
        return false;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public synchronized String submitMove(String playerName, int x, int y) {
        if (!gameStarted || !players.containsKey(playerName)) {
            return "Invalid move";
        }
        if (!currentPlayer.equals(playerName)) {
            return "Not your turn";
        }

        GameBoard board = playerName.equals(players.keySet().toArray()[0]) ? board2 : board1;
        String result = board.receiveMove(x, y);

        // Switch turn to the other player
        currentPlayer = playerName.equals(players.keySet().toArray()[0]) ? (String) players.keySet().toArray()[1] : (String) players.keySet().toArray()[0];

        return result;
    }

    public void printBoards() {
        System.out.println("Board for Player 1:");
        board1.printBoard();
        System.out.println("Board for Player 2:");
        board2.printBoard();
    }
}
