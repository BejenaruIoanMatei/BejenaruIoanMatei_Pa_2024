package org.example;

import java.util.Random;

public class GameBoard {
    private final char[][] board;

    public GameBoard() {
        board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = '~';
            }
        }
        placeShips();
    }

    // Place ships randomly on the board for testing purposes
    private void placeShips() {
        Random random = new Random();
        int shipsPlaced = 0;
        while (shipsPlaced < 5) {  // Place 5 ships for simplicity
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (board[x][y] == '~') {
                board[x][y] = 'S';
                shipsPlaced++;
            }
        }
    }

    public String receiveMove(int x, int y) {
        if (board[x][y] == '~') {
            board[x][y] = 'M';  // Miss
            return "Miss";
        } else if (board[x][y] == 'S') {
            board[x][y] = 'H';  // Hit
            return "Hit";
        }
        return "Already hit this spot";
    }

    public void printBoard() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
