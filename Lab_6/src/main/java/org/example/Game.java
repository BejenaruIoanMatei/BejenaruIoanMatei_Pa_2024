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
    private Color turn; // Rosu sau albastru
    private boolean gameOver;

    public Game(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.stones = new ArrayList<>();
        this.turn = Color.RED; // Incepe albastru ca i culoarea mea preferata :))
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
            Color color = (random.nextBoolean()) ? Color.RED : Color.BLUE;
            stones.add(new Stone(row, col, color));
        }
    }

    public boolean isValidMove(int row, int col) {
        return true;
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
        // Aici ar trebui sa vina logica pentru castigator
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
