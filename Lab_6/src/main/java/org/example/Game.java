package org.example;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;
    private int rows;
    private int cols;
    private List<Stone> stones;
    private Color turn; // Red or Blue
    private boolean gameOver;

    public Game(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.stones = new ArrayList<>();
        this.turn = Color.RED; // Red starts the game
        this.gameOver = false;
    }

    public void initialize() {
        generateSticks();
    }

    private void generateSticks() {
        Random random = new Random();
        for (int i = 0; i < rows * cols; i++) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);
            Color color = (random.nextBoolean()) ? Color.RED : Color.BLUE; // Alternăm între roșu și albastru
            stones.add(new Stone(row, col, color));
        }
    }

    public boolean isValidMove(int row, int col) {
        // Check if the move is valid according to the game rules
        // Implement your validation logic here
        return true; // Placeholder, modify as needed
    }

    public void makeMove(int row, int col) {
        if (!gameOver && isValidMove(row, col)) {
            Color stoneColor = (turn == Color.RED) ? Color.RED : Color.BLUE;
            stones.add(new Stone(row, col, stoneColor));
            switchTurn();
            checkWinner();
        }
    }

    private void switchTurn() {
        turn = (turn == Color.RED) ? Color.BLUE : Color.RED;
    }

    private void checkWinner() {
        // Check if there is a winner
        // Implement your win condition logic here
    }

    public List<Stone> getStones() {
        return stones;
    }

    public Color getTurn() {
        return turn;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
